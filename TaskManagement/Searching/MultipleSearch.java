package TaskManagement.Searching;

import java.util.List;

import TaskManagement.Task;

public class MultipleSearch implements Search{

    List<Search> seachingMethods;
    public MultipleSearch(List<Search> searchs) {
        this.seachingMethods = searchs;
    }
    @Override
    public boolean isSatisfyBy(Task task) {
        
        for(Search search : seachingMethods) {
            
            if(!search.isSatisfyBy(task)) return false;
        }

        return true;
    }
    
}
