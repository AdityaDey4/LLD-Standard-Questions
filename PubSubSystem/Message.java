package PubSubSystem;

public class Message {
    private String message;
    private Topic topic;

    Message(String message, Topic topic) {
        this.message = message;
        this.topic = topic;
    }

    public String getMessage() {
        return this.message;
    }

    public Topic getTopic() {
        return this.topic;
    }
}
