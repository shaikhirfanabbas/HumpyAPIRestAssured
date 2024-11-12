package api.endpoints;


public class Routes {
    public static final String BASE_URL = ("https://qa-api.humpyfarms.com/api");  // Use environment variables for flexibility
    public static final String POST_URL_SAVE = BASE_URL + "/customers/saveCustomerInfo";
    public static final String ADD_WALLET_HISTORY_URL = BASE_URL + "/wallet/addWalletNBillingHistory";
    public static final String ADD_ADDRESS_URL = BASE_URL + "/customerAddress/add";
    public static final String GET_ADDRESS_URL = BASE_URL + "/customerAddress/byCustomerId"; 
    public static final String ORDER_PLACE_URL = BASE_URL + "/orders/placeOrder";
   
    
}
