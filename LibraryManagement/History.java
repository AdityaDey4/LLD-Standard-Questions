package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class History {
    List<Record> records;

    History() {
        records = new ArrayList<>();
    }

    public void addHistory(Record record) {
        records.add(record);
    }

    public void printAllHistory() {
        
        for(Record record : records) {
            record.printRecord();
        }
    }
}
