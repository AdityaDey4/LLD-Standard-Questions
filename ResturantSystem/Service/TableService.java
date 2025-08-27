package ResturantSystem.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import ResturantSystem.Enum.TableStatus;
import ResturantSystem.Model.Table;

public class TableService {
    private final Map<String, Table> tables = new ConcurrentHashMap<>();

    public Table addTable(String tableId, int capacity) {
        Table table = new Table(tableId, capacity, TableStatus.AVAILABLE);
        tables.put(tableId, table);
        return table;
    }

    public Table get(String tableId) { return tables.get(tableId); }

    public boolean reserve(String tableId) {
        Table t = tables.get(tableId);
        if (t == null) return false;
        if (t.getTableStatus() == TableStatus.AVAILABLE) {
            t.setTableStatus(TableStatus.RESERVED);
            return true;
        }
        return false;
    }

    public void release(String tableId) {
        Table t = tables.get(tableId);
        if (t != null) t.setTableStatus(TableStatus.AVAILABLE);
    }

    public List<Table> listTables() { return new ArrayList<>(tables.values()); }
}
