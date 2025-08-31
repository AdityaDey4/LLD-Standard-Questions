package ConcertBookingSystem.Strategy;

public class NotificationFactory {
    
    public static Notification getNotification(String preference) {

        if(preference.equalsIgnoreCase("email")) return new EmailNotification();
        else if(preference.equalsIgnoreCase("sms")) return new SMSNotification();
        else throw new IllegalArgumentException("Invalid Notification Preference");
    }
}
