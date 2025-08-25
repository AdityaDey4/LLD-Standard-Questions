package TaskManagement.Searching;

import TaskManagement.Task;
import TaskManagement.Enum.Priority;

public class PrioritySearch implements Search{

    Priority priority;
    public PrioritySearch(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean isSatisfyBy(Task task) {
        return task.priority == this.priority;
    }
}
