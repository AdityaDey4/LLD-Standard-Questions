package OnlineMeeting;

public class User implements NoftifyObserver {
    String name;
    String email;
    User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void notifyUsers(MeetingDetails md) {
        System.out.println("Hello "+name+", you have been invited for the upcoming meeting. Time : "+md.interval.getTime());
    }
}
