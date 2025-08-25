package TaskManagement;

import java.util.List;

import TaskManagement.Searching.MultipleSearch;
import TaskManagement.Searching.TaskFilter;
import TaskManagement.Sorting.Sorting;

public class SearchSortEngine {
    
    public static List<Task> searchSort(List<Task> tasks, MultipleSearch search, Sorting sort) {
        
        TaskFilter filter = new TaskFilter();
        List<Task> filteredTasks = search == null ? tasks : filter.filter(tasks, search);
        if(sort != null) {
            sort.sort(filteredTasks);
        }

        return filteredTasks;
    }
}
