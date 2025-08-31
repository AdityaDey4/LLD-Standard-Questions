package ConcertBookingSystem.Models;

import ConcertBookingSystem.Strategy.Notification;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    Notification notificationPreference;

    public User(int id, String name, String email, String phone, Notification notification) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.notificationPreference = notification;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return this.email; }
    public String getPhone() { return this.phone; }
    public Notification getNotificationPreference() {
        return this.notificationPreference;
    }
}
