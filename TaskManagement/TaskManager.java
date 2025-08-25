package TaskManagement;

import java.util.ArrayList;
import java.util.List;

import TaskManagement.Enum.Action;
import TaskManagement.Enum.Priority;
import TaskManagement.Enum.Status;
import TaskManagement.Searching.MultipleSearch;
import TaskManagement.Sorting.Sorting;

public class TaskManager {
    
    private static TaskManager manager = null;
    List<User> users;
    List<Task> tasks;

    private TaskManager() {
        users = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public static TaskManager getManagerInstance() {
        if(manager == null) {
            manager = new TaskManager();
        }

        return manager;
    }

    public User createUser(String name, int age) {
        User user = new User(name, age);
        users.add(user);

        return user;
    }

    public Task createTask(User user, String name, String desc, Priority priority) {
        Task task = new Task(user, name, desc, priority);
        tasks.add(task);

        user.addActivity(task, Action.CREATED);
        return task;
    }

    public List<Task> getCreatedTasks(User user) {
        List<Task> createdTasks = new ArrayList<>();
        for(Task task : tasks) {
            if(task.created_by == user) createdTasks.add(task);
        }

        return createdTasks;
    } 

    public List<Task> getAssignedTasks(User user) {
        List<Task> assignedTasks = new ArrayList<>();
        for(Task task : tasks) {
            if(task.assigned_to == user) assignedTasks.add(task);
        }

        return assignedTasks;
    } 

    public void printUserTasks(User user) {

        List<Task> created = getCreatedTasks(user);
        List<Task> assigned = getAssignedTasks(user);

        print(user, created, assigned);
    }

    private void print(User user, List<Task> created, List<Task> assigned) {
        System.out.println("Total task created by User : "+user.name+" is "+created.size());
        for(Task task : created) {
            task.printFormattedTask();
        }
        System.out.println();

        System.out.println("Total task assigned to User : "+user.name+" is "+assigned.size());
        for(Task task : assigned) {
            task.printFormattedTask();
        }
        System.out.println();
    }

    public void changeTaskStatus(User assigned_to, Task task, Status newStatus) {
        if(task.assigned_to != assigned_to) {
            System.out.println("You are not the authorized one to perform this operation");
        }
        boolean updated = task.updateStatus(newStatus);

        if(updated) {
            assigned_to.addActivity(task, Action.UPDATED);
        }
    }

    public void assignTask(User created_by, Task task, User assigned_to) {
        if(task.created_by != created_by) {
            System.out.println("You are not the authorized one to perform this operation");
        }
        boolean assigned = task.assignUser(assigned_to);

        if(assigned) {
            created_by.addActivity(task, Action.ASSIGNED);
        }
    }

    public void showActivities(User user) {
        for(Activity ac : user.activities) {
            ac.printFormattedActivity();
        }

        System.out.println();
    }

    public void searchSortTask(User user, MultipleSearch search, Sorting sort) {

        List<Task> created = getCreatedTasks(user);
        List<Task> assigned = getAssignedTasks(user);


        List<Task> filteredCreatedTasks = SearchSortEngine.searchSort(created, search, sort);
        List<Task> filteredAssignedTasks = SearchSortEngine.searchSort(assigned, search, sort);

        print(user, filteredCreatedTasks, filteredAssignedTasks);
    }

}
