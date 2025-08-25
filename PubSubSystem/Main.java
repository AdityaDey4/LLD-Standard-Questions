package PubSubSystem;

public class Main {
    public static void main(String args[]) {

        PubSubSystem system = new PubSubSystem();

        Publisher p1 = new Publisher("Barcelone", "Spain");
        Publisher p2 = new Publisher("River Plate", "Argentina");

        system.addPublisher(p1);
        system.addPublisher(p2);

        Subscribers s1 = new Subscribers("Aditya Dey");
        Subscribers s2 = new Subscribers("Yash Khurana");

        Topic t1 = new Topic("New Signings");
        Topic t2 = new Topic("Training Sesson");

        system.subscribe(t1, s1);
        system.subscribe(t1, s2);

        system.subscribe(t2, s1);

        system.publishMessage(p1, t1, "Joan Garcia is a culer");
        system.publishMessage(p2, t2, "River Plate has decided to skip today's training sesson");

        system.unsubscribe(t1, s2);
        system.publishMessage(p1, t1, "New signing alert!! Marcus Rashford has been signed on loan from Manchecster United");

        system.printPublisherMessages(p1);
        system.printPublisherMessages(p2);
    }   
}
