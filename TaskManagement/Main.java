package TaskManagement;

import java.util.*;

import TaskManagement.Enum.Priority;
import TaskManagement.Enum.Status;
import TaskManagement.Searching.MultipleSearch;
import TaskManagement.Searching.Search;
import TaskManagement.Searching.StatusSearch;
import TaskManagement.Searching.TitleSearch;
import TaskManagement.Sorting.PrioritySort;

public class Main {
    public static void main(String[] args) {

        TaskManager manager = TaskManager.getManagerInstance();

        User aditya = manager.createUser("Aditya", 22);
        User rudra = manager.createUser("Rudra", 6);
        User rahul = manager.createUser("Rahul", 20);
        
        Task task1 = manager.createTask(aditya, "Frontend", "Develop Frontend", Priority.HIGH);
        Task task2 = manager.createTask(aditya, "Backend", "Develop Backend", Priority.HIGH);
        Task task3 = manager.createTask(rudra, "Database", "Create Schema", Priority.LOW);
        Task task4 = manager.createTask(aditya, "DevOps", "Manage Devops Team", Priority.MEDIUM);

        manager.assignTask(aditya, task1, rudra);
        manager.assignTask(aditya, task2, rahul);
        manager.assignTask(rudra, task3, aditya);
        manager.assignTask(aditya, task4, rudra);

        manager.changeTaskStatus(aditya, task3, Status.IN_PROGRESS);
        manager.changeTaskStatus(rahul, task2, Status.IN_PROGRESS);
        manager.changeTaskStatus(aditya, task3, Status.COMPLETED);

        manager.printUserTasks(aditya);
        // manager.showActivities(aditya);

        // manager.showActivities(rudra);
        // manager.showActivities(rahul);

        // task2.setReminder();

        List<Search> searchingMethods = new ArrayList<>();
        searchingMethods.add(new StatusSearch(Status.PENDING));
        searchingMethods.add(new TitleSearch("end"));
        MultipleSearch multipleSearch = new MultipleSearch(searchingMethods);
        
        manager.searchSortTask(aditya, multipleSearch, new PrioritySort(false));
    }
}
