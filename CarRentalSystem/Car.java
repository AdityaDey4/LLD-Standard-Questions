package CarRentalSystem;

import CarRentalSystem.Enum.Model;

public class Car {
    String id;
    Model model;
    String car_number;
    int year;
    long rent;
    

    Car(String id, Model model, String car_number, int year, long rent) {
        this.id = id;
        this.model = model;
        this.car_number = car_number;
        this.year = year;
        this.rent = rent;
    }

    public String getId() { return id; }
    public long getDailyRent(){return rent;}
}
