package api.payload;

import java.util.List;

public class OrderInfo {
    private int customer_id;
    private int warehouse_id;
    private int customer_address_id;
    private int user_id;
    private List<SubscriptionOrder> subscriptions_orders;

    // Getters and setters
    public int getCustomer_id() { return customer_id; }
    public void setCustomer_id(int customer_id) { this.customer_id = customer_id; }

    public int getWarehouse_id() { return warehouse_id; }
    public void setWarehouse_id(int warehouse_id) { this.warehouse_id = warehouse_id; }

    public int getCustomer_address_id() { return customer_address_id; }
    public void setCustomer_address_id(int customer_address_id) { this.customer_address_id = customer_address_id; }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public List<SubscriptionOrder> getSubscriptions_orders() { return subscriptions_orders; }
    public void setSubscriptions_orders(List<SubscriptionOrder> subscriptions_orders) { this.subscriptions_orders = subscriptions_orders; }

    // Inner class for SubscriptionOrder
    public static class SubscriptionOrder {
        private int sku_id;
        private String start_date;
        private int quantity;
        private int frequency_id;
        private int slot_id;

        // Getters and setters
        public int getSku_id() { return sku_id; }
        public void setSku_id(int sku_id) { this.sku_id = sku_id; }

        public String getStart_date() { return start_date; }
        public void setStart_date(String start_date) { this.start_date = start_date; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public int getFrequency_id() { return frequency_id; }
        public void setFrequency_id(int frequency_id) { this.frequency_id = frequency_id; }

        public int getSlot_id() { return slot_id; }
        public void setSlot_id(int slot_id) { this.slot_id = slot_id; }
    }
}
