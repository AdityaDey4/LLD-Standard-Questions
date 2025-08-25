package TaskManagement.Searching;

import TaskManagement.Task;
import TaskManagement.Enum.Status;

public class StatusSearch implements Search{

    Status status;
    public StatusSearch(Status status) {
        this.status = status;
    }

    @Override
    public boolean isSatisfyBy(Task task) {
        return task.status == this.status;
    }
    
}
