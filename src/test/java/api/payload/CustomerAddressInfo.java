package api.payload;

public class CustomerAddressInfo {
    private int city_id;
    private String address_1;
    private String address_2;
    private String latitude;
    private String longitude;
    private int is_default;
    private int is_apartment;
    private int society_id;
    private String address_tag;
    private int area_id;
    private int subarea_id;
    private String society_name;
    private int customer_id; // Customer ID from the createCustomer response

    // Getters and setters
    public int getCity_id() { return city_id; }
    public void setCity_id(int city_id) { this.city_id = city_id; }

    public String getAddress_1() { return address_1; }
    public void setAddress_1(String address_1) { this.address_1 = address_1; }

    public String getAddress_2() { return address_2; }
    public void setAddress_2(String address_2) { this.address_2 = address_2; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public int getIs_default() { return is_default; }
    public void setIs_default(int is_default) { this.is_default = is_default; }

    public int getIs_apartment() { return is_apartment; }
    public void setIs_apartment(int is_apartment) { this.is_apartment = is_apartment; }

    public int getSociety_id() { return society_id; }
    public void setSociety_id(int society_id) { this.society_id = society_id; }

    public String getAddress_tag() { return address_tag; }
    public void setAddress_tag(String address_tag) { this.address_tag = address_tag; }

    public int getArea_id() { return area_id; }
    public void setArea_id(int area_id) { this.area_id = area_id; }

    public int getSubarea_id() { return subarea_id; }
    public void setSubarea_id(int subarea_id) { this.subarea_id = subarea_id; }

    public String getSociety_name() { return society_name; }
    public void setSociety_name(String society_name) { this.society_name = society_name; }

    public int getCustomer_id() { return customer_id; }
    public void setCustomer_id(int customer_id) { this.customer_id = customer_id; }
}

