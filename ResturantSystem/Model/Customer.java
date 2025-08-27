package ResturantSystem.Model;

public class Customer {
    
    private final String id;
    private final String name;
    private long phone;

    public Customer(String id, String name, long phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
