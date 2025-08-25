package PubSubSystem;

public class Publisher {
    
    private String name;
    private String location;

    Publisher(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }
}
