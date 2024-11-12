package api.payload;

public class WalletHistoryInfo {

	  private String remark;
	    private int amount;
	    private String transaction_type;
	    private String transaction_amount_type;
	    private int customer_id;

	    // Getters and Setters
	    public String getRemark() { return remark; }
	    public void setRemark(String remark) { this.remark = remark; }

	    public int getAmount() { return amount; }
	    public void setAmount(int amount) { this.amount = amount; }

	    public String getTransaction_type() { return transaction_type; }
	    public void setTransaction_type(String transaction_type) { this.transaction_type = transaction_type; }

	    public String getTransaction_amount_type() { return transaction_amount_type; }
	    public void setTransaction_amount_type(String transaction_amount_type) { this.transaction_amount_type = transaction_amount_type; }

	    public int getCustomer_id() { return customer_id; }
	    public void setCustomer_id(int customer_id) { this.customer_id = customer_id; }
}
