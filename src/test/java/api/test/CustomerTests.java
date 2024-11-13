package api.test;

import api.endpoints.CustomerEndPoints;
import api.payload.CustomerAddressInfo;
import api.payload.CustomerInfo;
import api.payload.OrderInfo;
import api.payload.OrderInfo.SubscriptionOrder;
import api.payload.WalletHistoryInfo;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class CustomerTests {

    Faker faker;
    CustomerInfo customerPayload;
    WalletHistoryInfo walletPayload;
    public Logger logger;
    private int customerId;  // This will store the generated customer_id
    private int customerAddressId;
    private int warehouseId = 1; // Assuming a fixed warehouseId for this example
    private int userId = 9; // Assuming a fixed userId for this example
    //int customerEnd=new CustomerEndPoints();
    @BeforeClass
    public void setup() throws Exception {
        // Sleep for setup delay (if required for resource availability)
        Thread.sleep(2000);

        // Initialize Faker instance for data generation
        faker = new Faker();
        customerPayload = new CustomerInfo();

        // Set Customer Payload fields with random values using Faker
        customerPayload.setCustomer_first_name(faker.name().firstName());
        customerPayload.setCustomer_last_name(faker.name().lastName());
        customerPayload.setEmail(faker.internet().emailAddress());
        customerPayload.setMobile(faker.number().digits(10));
        customerPayload.setSource_of_referral(faker.number().numberBetween(1, 5));
        customerPayload.setAvatar("images/customer/" + faker.number().digits(10) + ".jpeg");
        customerPayload.setRegistered_date("2024-11-13");
        customerPayload.setIs_new(1);  // Set status to 'new' by default
        customerPayload.setCan_ring_bell(0);
        customerPayload.setCan_sms_send(0);
        customerPayload.setCan_notification_send(0);
        customerPayload.setCan_email_send(0);
        customerPayload.setCan_whatsapp_send(0);
        customerPayload.setBlock_comment("Test Comment");

        // Setting up the Customer Profile (nested object)
        CustomerInfo.CustomerProfile profile = new CustomerInfo.CustomerProfile();
        profile.setDob("2024-08-28");  // Set a default date of birth
        profile.setGender(faker.demographic().sex());  // Random gender
        profile.setHeight(faker.number().numberBetween(150, 200));  // Random height between 150-200 cm
        profile.setWeight(faker.number().numberBetween(50, 100));  // Random weight between 50-100 kg
        profile.setAvatar("images/customer/" + faker.number().digits(10) + ".jpeg");
        profile.setActivity_level("Secondary");  // Fixed activity level
        profile.setFood_preferences("Vegetarian");  // Fixed food preference
        profile.setHealth_issues(faker.number().numberBetween(1, 3));  // Random health issues number
        profile.setRelationship("Manager");  // Fixed relationship value

        customerPayload.setCustomer_profile(profile);

        // Logger setup for logging purposes
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testCreateCustomer() throws Exception {
    	Thread.sleep(2000);
        logger.info("*************** Creating Customer **********");

        // Send POST request to create customer
        Response response = CustomerEndPoints.createCustomer(customerPayload);
        response.then().log().all();

        // Verify the status code and extract customer_id
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected");

        // Extract customer_id from the response and store it
        customerId = response.jsonPath().getInt("result.customer_id");
        Assert.assertNotEquals(customerId, 0, "Customer ID should be valid and non-zero");

        // Print customer_id to console for verification
        logger.info("*************** Customer Created Successfully with ID: " + customerId + " **********");
    }

    @Test(priority = 2, dependsOnMethods = "testCreateCustomer")
    public void testAddWalletHistory() throws Exception {
    	Thread.sleep(2000);
        logger.info("*************** Adding Wallet History **********");

        // Check if customer_id is set
        Assert.assertNotEquals(customerId, 0, "Customer ID should be available before adding wallet history");

        // Setting wallet payload fields
        walletPayload = new WalletHistoryInfo();
        walletPayload.setRemark("Test Wallet Transaction");
        walletPayload.setAmount(100000000);
        walletPayload.setTransaction_type("Recharge");
        walletPayload.setTransaction_amount_type("CREDIT");

        // Log customer_id before setting in the payload
        System.out.println(customerId);
        logger.info("*************** Adding Wallet History for Customer ID: " + customerId + " **********");

        // Set the customer_id to walletPayload
        walletPayload.setCustomer_id(customerId); // Using the customer ID from the previous test

        // Send POST request to add wallet history
        Response response = CustomerEndPoints.addWalletHistory(walletPayload);
        response.then().log().all();

        // Verify the status code and response
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected");

        logger.info("*************** Wallet History Added Successfully for Customer ID: " + customerId + " **********");
    }
    
    @Test(priority = 3, dependsOnMethods = "testCreateCustomer")
    public void testAddCustomerAddress() throws Exception {
    	Thread.sleep(2000);
        logger.info("*************** Adding Customer Address **********");

        // Verify that the customer_id from testCreateCustomer is valid
        Assert.assertNotEquals(customerId, 0, "Customer ID should be available before adding address");

        // Set up the address payload using the CustomerAddressInfo class
        CustomerAddressInfo addressPayload = new CustomerAddressInfo();
        addressPayload.setCity_id(1);
        addressPayload.setAddress_1("New DP road");
        addressPayload.setAddress_2("");
        addressPayload.setLatitude("18.566523");
        addressPayload.setLongitude("73.83966749999999");
        addressPayload.setIs_default(1);
        addressPayload.setIs_apartment(1);
        addressPayload.setSociety_id(985);
        addressPayload.setAddress_tag("home");
        addressPayload.setArea_id(99);
        addressPayload.setSubarea_id(473);
        addressPayload.setSociety_name("Chetak society, Anupam Nagar, Khadki, Pune, Maharashtra, India");
        addressPayload.setCustomer_id(customerId); // Use customer ID from testCreateCustomer

        // Log the customer_id before sending the request
        logger.info("Adding address for Customer ID: " + customerId);

        // Send POST request to add customer address
        Response response = CustomerEndPoints.addCustomerAddress(addressPayload);
        response.then().log().all();

        // Verify the response status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected");
        logger.info("*************** Customer Address Added Successfully for Customer ID: " + customerId + " **********");
    }
    
    //Get address details
    
    @Test(priority = 4)
    public void testGetCustomerAddressByCustomerId() throws Exception {
    	Thread.sleep(2000);
        // Ensure that customerId is valid
        Assert.assertNotEquals(customerId, 0, "Customer ID should be available before fetching customer address");

        // Call the endpoint to fetch customer address by customer ID
        Response response = CustomerEndPoints.getCustomerAddressByCustomerId(customerId);
        response.then().log().all();
        System.out.println("Customer Address Response: " + response.getBody().asString());

        // Validate the response status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected");

        // Extract customerAddressId from response
        customerAddressId = response.jsonPath().getInt("result[0].customer_address_id");
        System.out.println("Fetched Customer Address ID: " + customerAddressId);

        // Assert to confirm valid ID was fetched
        Assert.assertNotEquals(customerAddressId, 0, "Customer Address ID should be valid.");
    }

    @Test(priority = 5, dependsOnMethods = "testGetCustomerAddressByCustomerId")
    public void testPlaceOrder() throws Exception {
    	Thread.sleep(2000);
        // Ensure IDs are valid
        Assert.assertNotEquals(customerId, 0, "Customer ID should be valid.");
        Assert.assertNotEquals(customerAddressId, 0, "Customer Address ID should be valid.");
        Assert.assertNotEquals(warehouseId, 0, "Warehouse ID should be valid.");

        // Set up the order information payload
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCustomer_id(customerId);
        orderInfo.setWarehouse_id(warehouseId);
        orderInfo.setCustomer_address_id(customerAddressId); // Use customerAddressId fetched from the previous test
        orderInfo.setUser_id(userId);

        // Create a list for subscription orders and set order details
        List<OrderInfo.SubscriptionOrder> subscriptionOrders = new ArrayList<OrderInfo.SubscriptionOrder>();
        OrderInfo.SubscriptionOrder subscriptionOrder = new OrderInfo.SubscriptionOrder();

        subscriptionOrder.setSku_id(1001);
        subscriptionOrder.setStart_date("2024-11-13");
        subscriptionOrder.setQuantity(3);
        subscriptionOrder.setFrequency_id(1);
        subscriptionOrder.setSlot_id(1);
        subscriptionOrders.add(subscriptionOrder);

        // Add subscription orders to orderInfo
        orderInfo.setSubscriptions_orders(subscriptionOrders);

        // Call the placeOrder endpoint
        Response response = CustomerEndPoints.placeOrder(orderInfo);

        // Log the response for debugging
        System.out.println("Place Order Response: " + response.getBody().asString());

        // Validate the response status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected");

        // Additional logging for successful order placement
        System.out.println("Order placed successfully with customer_id: " + customerId);
    }
    @Test(priority = 6, dependsOnMethods = "testPlaceOrder")
    public void testPlaceOrderAlternative() throws Exception {
    	Thread.sleep(2000);
        // Ensure IDs are valid
        Assert.assertNotEquals(customerId, 0, "Customer ID should be valid.");
        Assert.assertNotEquals(customerAddressId, 0, "Customer Address ID should be valid.");
        Assert.assertNotEquals(warehouseId, 0, "Warehouse ID should be valid.");

        // Set up the order information payload
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCustomer_id(customerId);
        orderInfo.setWarehouse_id(warehouseId);
        orderInfo.setCustomer_address_id(customerAddressId); // Use customerAddressId fetched from the previous test
        orderInfo.setUser_id(userId);

        // Create a list for subscription orders and set order details
        List<OrderInfo.SubscriptionOrder> subscriptionOrders = new ArrayList<OrderInfo.SubscriptionOrder>();
        OrderInfo.SubscriptionOrder subscriptionOrder = new OrderInfo.SubscriptionOrder();

        subscriptionOrder.setSku_id(1004);
        subscriptionOrder.setStart_date("2024-11-13");
        subscriptionOrder.setQuantity(10);
        subscriptionOrder.setFrequency_id(2);
        subscriptionOrder.setSlot_id(1);
        subscriptionOrders.add(subscriptionOrder);

        // Add subscription orders to orderInfo
        orderInfo.setSubscriptions_orders(subscriptionOrders);

        // Call the placeOrder endpoint
        Response response = CustomerEndPoints.placeOrder(orderInfo);

        // Log the response for debugging
        System.out.println("Place Order Response: " + response.getBody().asString());

        // Validate the response status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected");

        // Additional logging for successful order placement
        System.out.println("Order placed successfully with customer_id: " + customerId);
    }
    @Test
    public void runAllTestsTenTimes() throws Exception {
        for (int i = 0; i < 2; i++) {
            System.out.println("Running iteration: " + (i + 1));
            
            // Manually call the setup method to reinitialize necessary data for each iteration
            setup();
            
            // Call testCreateCustomer and check if it passes before moving to the next test
            try {
                testCreateCustomer();
            } catch (AssertionError e) {
                System.out.println("testCreateCustomer failed, stopping further tests in this iteration");
                break; // Stop further tests if customer creation fails
            }

            // Call each test method in sequence
            testAddWalletHistory();
            testAddCustomerAddress();
            testGetCustomerAddressByCustomerId();
            testPlaceOrder();
            testPlaceOrderAlternative();

            // Output completed iteration message
            System.out.println("Iteration " + (i + 1) + " completed");
            
            // Check if it is iteration 2, if so, break the loop and stop execution
            if (i == 1) {
                System.out.println("Iteration 2 completed, stopping further execution.");
                return;  // Instead of break, we use return to immediately stop method execution.
            }
        }
    }


}

	