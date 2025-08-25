package TaskManagement.Searching;

import TaskManagement.Task;

public class TitleSearch implements Search {

    String title;
    public TitleSearch(String title) {
        this.title = title;
    }
    @Override
    public boolean isSatisfyBy(Task task) {
        return task.title.contains(title) || task.desc.contains(title);
    }
    

}
