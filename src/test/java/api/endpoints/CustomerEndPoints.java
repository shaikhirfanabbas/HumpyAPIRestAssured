package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.CustomerAddressInfo;
import api.payload.CustomerInfo;
import api.payload.OrderInfo;
import api.payload.WalletHistoryInfo;


public class CustomerEndPoints {

    // Authorization token for API requests - replace with your actual token
    private static final String AUTH_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo5LCJpYXQiOjE3MzEzNDMyNDgsImV4cCI6MTczMTc3NTI0OH0.qM-1eIhF-Q3qghxc1LG6vt3MTSu6Tu6Ox1H8LAbjcWs";

    // Method to create a new customer
    public static Response createCustomer(CustomerInfo payload) {
        return RestAssured.given()
                .header("Authorization", AUTH_TOKEN)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .post(Routes.POST_URL_SAVE);
    }
 // Method to add wallet history for a customer
    public static Response addWalletHistory(WalletHistoryInfo walletPayload) {
        return RestAssured.given()
                .header("Authorization", AUTH_TOKEN)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(walletPayload)
                .post(Routes.ADD_WALLET_HISTORY_URL);
    }
    
    //Add Address 
    
    public static Response addCustomerAddress(CustomerAddressInfo addressPayload) {
        return RestAssured.given()
                .header("Authorization", AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body(addressPayload)
            .when()
                .post(Routes.ADD_ADDRESS_URL);
    }
    
    //Get address details
    
    public static Response getCustomerAddressByCustomerId(int customerId) {
        // Construct the URL with dynamic customer_id
        String url = String.format("%s?pageIndex=1&customer_id=%d&pageSize=10&sort[order]=&sort[key]=&query=", Routes.GET_ADDRESS_URL, customerId);

        // Send GET request to fetch customer address details by customer ID
        return RestAssured.given()
                .header("Authorization", AUTH_TOKEN)
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Cache-Control", "no-cache")
                .header("Origin", "https://qa-humpy-admin.digitalflake.com")
                .header("Pragma", "no-cache")
                .header("Priority", "u=1, i")
                .header("Referer", "https://qa-humpy-admin.digitalflake.com/")
                .header("Sec-CH-UA", "\"Chromium\";v=\"130\", \"Google Chrome\";v=\"130\", \"Not?A_Brand\";v=\"99\"")
                .header("Sec-CH-UA-Mobile", "?0")
                .header("Sec-CH-UA-Platform", "\"Windows\"")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "cross-site")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36")
                .get(url); // Make the GET request with dynamic customer_id
    }

    
    //Order place
    
    public static Response placeOrder(OrderInfo orderInfo) {
        return RestAssured.given()
                .header("Authorization", AUTH_TOKEN)
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Cache-Control", "no-cache")
                .header("Content-Type", "application/json")
                .header("Origin", "https://qa-humpy-admin.digitalflake.com")
                .header("Pragma", "no-cache")
                .header("Priority", "u=1, i")
                .header("Referer", "https://qa-humpy-admin.digitalflake.com/")
                .header("Sec-CH-UA", "\"Chromium\";v=\"128\", \"Google Chrome\";v=\"128\", \"Not;A=Brand\";v=\"24\"")
                .header("Sec-CH-UA-Mobile", "?0")
                .header("Sec-CH-UA-Platform", "\"Windows\"")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "cross-site")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36")
                .body(orderInfo)
                .post(Routes.ORDER_PLACE_URL);
    }


}
