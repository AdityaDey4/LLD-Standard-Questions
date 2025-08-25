package TaskManagement;

import java.time.LocalDate;

import TaskManagement.Enum.Priority;
import TaskManagement.Enum.Status;

public class Task {
    
    public String title;
    public String desc;
    public LocalDate due_date;
    public Status status;
    public Priority priority;

    User created_by;
    User assigned_to;

    Task(User created_by, String title, String desc, Priority priority) {
        this.created_by = created_by;
        this.title = title;
        this.desc = desc;
        this.priority = priority;
        this.status = Status.PENDING;
    }

    public boolean updateStatus(Status newStatus) {

        if(status.ordinal() >= newStatus.ordinal()) return false;

        this.status = newStatus;
        return true;
    }

    public boolean assignUser(User assigned_to) {

        if(this.assigned_to != null) {
            System.out.println("For this task, "+this.assigned_to.name+" has already been assigned.");
            return false;
        }

        this.assigned_to = assigned_to;
        return true;
    }

    public boolean setReminder() {
        if(this.assigned_to == null) {
            System.out.println("For this task, User has not been assigned yet.");
            return false;
        }

        assigned_to.reminder();
        return true;
    }

    public void setDueDate(LocalDate date) {
        this.due_date = date;
    }

    public void printFormattedTask() {

        String due_date_st = this.due_date != null ? " Due Date : "+this.due_date : "";
        String assigned_to_st = this.assigned_to != null ? " Assigned to : "+this.assigned_to.name : "";

        System.out.println("Created by : "+created_by.name+" Title : "+title+" Priority : "+priority+" Status : "+this.status+due_date_st+assigned_to_st);
    }
}
