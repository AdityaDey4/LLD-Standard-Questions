package DigitalWalletService;


public class User {
    
    private final String id;
    private final String name;
    private int phone;

    User(String id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId(){return this.id;}
    public String getName(){return this.name;}
    public int getPhone(){return this.phone;}

}
