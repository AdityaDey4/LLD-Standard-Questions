package CarRentalSystem.Service;

import java.util.List;
import java.util.Optional;

import CarRentalSystem.Car;
import CarRentalSystem.Repository.CarRepository;

public class CarService {
    private final CarRepository repo;

    public CarService(CarRepository repo) { this.repo = repo; }

    public void addCar(Car car) { repo.save(car); }
    public List<Car> listAll() { return repo.findAll(); }
    public Optional<Car> findById(String carId) { return repo.findById(carId); }
}
