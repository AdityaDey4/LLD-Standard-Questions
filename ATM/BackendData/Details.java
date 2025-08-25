package ATM.BackendData;

import java.util.ArrayList;
import java.util.List;

public class Details {
    private static List<Data> list;
    private static Details instance;

    private Details(){}

    public static Details getInstance() {
        if(instance == null) {
            instance = new Details();
            list = new ArrayList<>();
            setUpList();
        } 

        return instance;
    }

    private static void setUpList() {
        list.add(new Data("123456789012", 1234, 2000));
        list.add(new Data("123456789013", 1234, 5000));
        list.add(new Data("123456789014", 2345, 400));
        list.add(new Data("123456789015", 2345, 20000));
    }

    public Data getSpecificData(String card) {
        for(Data data : list) {
            if(data.getCardNumber().equals(card)) return data;
        }

        return null;
    }
}
