package CarRentalSystem;

public class Customer {
    
    private final String id;
    String name;
    long contact;
    String dr_license_no;

    Customer(String id, String name, long contact, String dr_license_no) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.dr_license_no = dr_license_no;
    }

    public String getId() {return this.id;}
}
