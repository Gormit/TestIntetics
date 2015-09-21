package com.gormit.service;

import com.gormit.dao.impl.CarDaoImpl;
import com.gormit.pojos.Car;
import com.gormit.pojos.Client;

import java.util.List;

/**
 * Created by Gormit on 18.09.2015.
 * CarService class for work with CarDaoImpl
 */
public class CarService {

    /**
     * Send to CarDaoImpl a Client to search List of Cars by this Client
     * @param client - entity
     * @return List of Cars
     */
    public List<Car> getCarListByClient(Client client) {
        return new CarDaoImpl().getCarListByClient(client);
    }

    /**
     * Send to CarDaoImpl id, to search a Car
     * @param carId - Car ID
     * @return Car or null
     */
    public Car getCarById(int carId) {
        return new CarDaoImpl().get(carId);
    }

    /**
     * Send to CarDaoImpl a Car
     * if Car has ID - update
     * if Car has no ID - save
     * @param car - Entity
     */
    public void saveOrUpdate(Car car) {
        if (0 != car.getId()){
            new CarDaoImpl().update(car);
        } else {
            new CarDaoImpl().add(car);
        }
    }

    /**
     * Send to CarDaoImpl a Car, to delete it
     * @param car - entity
     */
    public void dellCar(Car car) {
        new CarDaoImpl().delete(car);
    }
}
