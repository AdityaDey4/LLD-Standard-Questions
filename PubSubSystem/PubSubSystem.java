package PubSubSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PubSubSystem {
    
    Map<Publisher, List<Message>> publishers;
    List<Topic> topics;

    PubSubSystem() {
        publishers = new HashMap<>();
        topics = new ArrayList<>();
    }

    public void addPublisher(Publisher p) {
        this.publishers.put(p, new ArrayList<>());
    }

    public void addTopic(Topic t) {
        this.topics.add(t);
    }

    public void subscribe(Topic topic, SubscriberObserver subscriber) {
        topic.addSubscriber(subscriber);
    }

    public void unsubscribe(Topic topic, SubscriberObserver subscriber) {
        topic.removeSubscriber(subscriber);
    }

    public void publishMessage(Publisher publisher, Topic topic, String messageString) {

        Message message = new Message(messageString, topic);
        publishers.get(publisher).add(message);
        System.err.println("Topic : "+message.getTopic().name+" Message : "+message.getMessage());

        notify(topic);
    }

    private void notify(Topic topic) {
        // Notify each subscriber asynchronously
        ExecutorService executor = Executors.newCachedThreadPool();
        for(SubscriberObserver subscriber : topic.subscribers) {
           executor.submit(()-> {
                try {
                    subscriber.notifySubscribers(topic);
                }catch(Exception e) {
                    System.err.println("[Error] Exception while notifying subscriber: " + e.getMessage());
                }
            });
        }
    }

    public void printPublisherMessages(Publisher publisher) {

        for(Message message : publishers.get(publisher)) {
            System.out.println("Topic : "+message.getTopic().name+" Message : "+message.getMessage());
        }
    }
}
