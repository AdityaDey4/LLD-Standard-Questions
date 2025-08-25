package PubSubSystem;

public class Subscribers implements SubscriberObserver {

    private String name;

    Subscribers(String name) {
        this.name = name;
    }

    @Override
    public void notifySubscribers(Topic topic) {
        System.err.println("Hello "+name+", a new message has been added on "+topic.name);
    }
    
}
