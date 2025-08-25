package TaskManagement.Sorting;

import java.util.List;

import TaskManagement.Task;

public class PrioritySort implements Sorting {

    boolean ascending;
    public PrioritySort( boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public void sort(List<Task> tasks) {
        
        if(ascending) {
            tasks.sort((a, b)-> a.priority.ordinal()-b.priority.ordinal());
        } else {
            tasks.sort((a, b)-> b.priority.ordinal()-a.priority.ordinal());
        }
    }
    
}
