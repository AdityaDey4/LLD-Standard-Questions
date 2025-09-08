package StackOverflow.Models;

public class User {
    private String id;
    private String name;
    private String email;
    private int reputation;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.reputation = 0; // default
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public int getReputation() { return reputation; }
    public void addReputation(int points) { this.reputation += points; }
    public void reduceReputation(int points) { this.reputation -= points; }
}
