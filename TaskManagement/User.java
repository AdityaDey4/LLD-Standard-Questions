package TaskManagement;

import java.util.ArrayList;
import java.util.List;

import TaskManagement.Enum.Action;

public class User {
    String name;
    int age;
    List<Activity> activities;

    User(String name, int age) {
        this.name = name;
        this.age = age;
        activities = new ArrayList<>();
    }

    public void reminder() {
        System.out.println(name+" has been notified");
    }

    public void addActivity(Task task, Action action) {
        activities.add(new Activity(this, action, task));
    }
}
