package dao;

import entity.Car;

import java.util.List;

public interface ICarDAO {
    void add(Car car);

    List<Car> getAll();

    Car getById(int id);

    void updatePrice(int price, Car car);

    void removeMark(String mark);

    void removeModel(String model);
}
