package TaskManagement.Sorting;

import java.util.List;

import TaskManagement.Task;

public class TitleSort implements Sorting {

    boolean ascending;
    public TitleSort( boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public void sort(List<Task> tasks) {
        
        if(ascending) {
            tasks.sort((a, b)-> a.title.compareToIgnoreCase(b.title));
        } else {
            tasks.sort((a, b)-> b.title.compareToIgnoreCase(a.title));
        }
    }
    
}
