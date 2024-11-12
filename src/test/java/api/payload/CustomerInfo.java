package api.payload;

public class CustomerInfo {

    private String customer_first_name;
    private String customer_last_name;
    private String email;
    private String mobile;
    private int source_of_referral;
    private String avatar;
    private String registered_date;
    private int is_new;
    private int can_ring_bell;
    private int can_sms_send;
    private int can_notification_send;
    private int can_email_send;
    private int can_whatsapp_send;
    private String block_comment;
    private CustomerProfile customer_profile;

    // Inner class for CustomerProfile
    public static class CustomerProfile {
        private String dob;
        private String gender;
        private int height;
        private int weight;
        private String avatar;
        private String activity_level;
        private String food_preferences;
        private int health_issues;
        private String relationship;

        // Getters and Setters for CustomerProfile fields
        public String getDob() { return dob; }
        public void setDob(String dob) { this.dob = dob; }

        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }

        public int getHeight() { return height; }
        public void setHeight(int height) { this.height = height; }

        public int getWeight() { return weight; }
        public void setWeight(int weight) { this.weight = weight; }

        public String getAvatar() { return avatar; }
        public void setAvatar(String avatar) { this.avatar = avatar; }

        public String getActivity_level() { return activity_level; }
        public void setActivity_level(String activity_level) { this.activity_level = activity_level; }

        public String getFood_preferences() { return food_preferences; }
        public void setFood_preferences(String food_preferences) { this.food_preferences = food_preferences; }

        public int getHealth_issues() { return health_issues; }
        public void setHealth_issues(int health_issues) { this.health_issues = health_issues; }

        public String getRelationship() { return relationship; }
        public void setRelationship(String relationship) { this.relationship = relationship; }
    }

    // Getters and Setters for CustomerInfo fields
    public String getCustomer_first_name() { return customer_first_name; }
    public void setCustomer_first_name(String customer_first_name) { this.customer_first_name = customer_first_name; }

    public String getCustomer_last_name() { return customer_last_name; }
    public void setCustomer_last_name(String customer_last_name) { this.customer_last_name = customer_last_name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public int getSource_of_referral() { return source_of_referral; }
    public void setSource_of_referral(int source_of_referral) { this.source_of_referral = source_of_referral; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getRegistered_date() { return registered_date; }
    public void setRegistered_date(String registered_date) { this.registered_date = registered_date; }

    public int getIs_new() { return is_new; }
    public void setIs_new(int is_new) { this.is_new = is_new; }

    public int getCan_ring_bell() { return can_ring_bell; }
    public void setCan_ring_bell(int can_ring_bell) { this.can_ring_bell = can_ring_bell; }

    public int getCan_sms_send() { return can_sms_send; }
    public void setCan_sms_send(int can_sms_send) { this.can_sms_send = can_sms_send; }

    public int getCan_notification_send() { return can_notification_send; }
    public void setCan_notification_send(int can_notification_send) { this.can_notification_send = can_notification_send; }

    public int getCan_email_send() { return can_email_send; }
    public void setCan_email_send(int can_email_send) { this.can_email_send = can_email_send; }

    public int getCan_whatsapp_send() { return can_whatsapp_send; }
    public void setCan_whatsapp_send(int can_whatsapp_send) { this.can_whatsapp_send = can_whatsapp_send; }

    public String getBlock_comment() { return block_comment; }
    public void setBlock_comment(String block_comment) { this.block_comment = block_comment; }

    public CustomerProfile getCustomer_profile() { return customer_profile; }
    public void setCustomer_profile(CustomerProfile customer_profile) { this.customer_profile = customer_profile; }
    
    
}
