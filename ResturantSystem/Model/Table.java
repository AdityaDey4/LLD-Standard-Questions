package ResturantSystem.Model;

import ResturantSystem.Enum.TableStatus;

public class Table {
    
    private final String id;
    private int capacity;
    private TableStatus tableStatus;

    public Table(String id, int capacity, TableStatus tableStatus) {
        this.id = id;
        this.capacity = capacity;
        this.tableStatus = tableStatus;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }
}
