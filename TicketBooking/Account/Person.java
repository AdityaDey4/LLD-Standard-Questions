package Account;

public abstract class Person {
    protected String name;
    protected String address;
    protected int phone;

    public Person(String name, String address, int ph) {
        this.name = name;
        this.address = address;
        this.phone = ph;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return this.phone;
    }
}
