package TaskManagement;

import java.time.LocalDateTime;

import TaskManagement.Enum.Action;

public class Activity {
    User user;
    Action action;
    LocalDateTime time;
    Task task;

    Activity(User user, Action action, Task task) {
        this.user = user;
        this.action = action;
        this.task = task;
        time = LocalDateTime.now();
    }

    public void printFormattedActivity() {
        System.out.println("User : "+user.name+" Action : "+action+" Task : "+task.title+" Time : "+time);
    }
}
