package CarRentalSystem.Repository;

import java.util.*;

import CarRentalSystem.Car;

public class CarRepository {

    private final Map<String, Car> cars = new HashMap<>();

    public void save(Car car) { cars.put(car.getId(), car); }
    public List<Car> findAll() { return new ArrayList<>(cars.values()); }
    public Optional<Car> findById(String id) { return Optional.ofNullable(cars.get(id)); }
    
}