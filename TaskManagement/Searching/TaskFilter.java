package TaskManagement.Searching;

import java.util.ArrayList;
import java.util.List;

import TaskManagement.Task;

public class TaskFilter {
    
    public List<Task> filter(List<Task> tasks, MultipleSearch search) {

        List<Task> filteredTasks = new ArrayList<>();
        for(Task task : tasks) {
            if(search.isSatisfyBy(task)) filteredTasks.add(task);
        }

        return filteredTasks;
    }
}
