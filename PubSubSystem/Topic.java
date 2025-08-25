package PubSubSystem;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    
    String name;
    List<SubscriberObserver> subscribers;

    Topic(String name) {
        this.name = name;
        subscribers = new ArrayList<>();
    }

    private boolean isAlreadySubscribed(SubscriberObserver subscriber) {
        return subscribers.contains(subscriber);
    }

    public void addSubscriber(SubscriberObserver subscriber) {
        if(! isAlreadySubscribed(subscriber)) this.subscribers.add(subscriber);
    }

    public void removeSubscriber(SubscriberObserver subscribe) {
        this.subscribers.remove(subscribe);
    }
}
