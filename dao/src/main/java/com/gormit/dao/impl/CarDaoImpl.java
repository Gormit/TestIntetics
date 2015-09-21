package com.gormit.dao.impl;

import com.gormit.dao.CarDao;
import com.gormit.pojos.Car;
import com.gormit.pojos.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gormit on 18.09.2015.
 * Class works with methods unique to Car-entity implements CarDao interface
 */
public class CarDaoImpl extends DaoImpl<Car> implements CarDao {

    private static final Logger logger = Logger.getLogger(CarDaoImpl.class);

    /**
     * Simple Save method, witch save Entity in DB
     * @param car - entity
     */
    @Override
    public void add(Car car) {
        String sql = "INSERT INTO car (make, model, year, VIN, client_id) " +
                "values ('" + car.getMake() + "', '" + car.getModel() + "', '" + car.getYear() + "', '" + car.getVin() + "', '" + car.getClient().getId() + "')";
        try {
            Connection connection = DaoImpl.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }
    }

    /**
     * Simple Get method, witch return Entity from DB
     * @param id - ID Entity
     * @return Car-entity
     */
    @Override
    public Car get(int id) {
        Car car = null;
        String query = "SELECT * FROM car WHERE id='" + id + "'";
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setMake(resultSet.getString("make"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getString("year"));
                car.setVin(resultSet.getString("VIN"));
                car.setClient(new ClientDaoImpl().get(resultSet.getInt("client_id")));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }

        return car;
    }

    /**
     * Simple update method, with update Entity by ID
     * @param car - entity
     */
    @Override
    public void update(Car car) {
        String query = "UPDATE car SET make='" + car.getMake() + "', model='" + car.getModel() + "', year='" + car.getYear() + "', VIN='" + car.getVin() + "' WHERE  id=" + car.getId();
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }

    }


    /**
     * Simple delete method, with delete Entity from DB
     * @param car - entity
     */
    @Override
    public void delete(Car car) {
        String query = "DELETE FROM car WHERE id=" + car.getId();
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }
    }

    /**
     * Method get Client's list of Cars
     * @param client - entity
     * @return List of Cars
     */
    @Override
    public List<Car> getCarListByClient(Client client) {
        String query = "SELECT * FROM car WHERE client_id=" + client.getId();
        List<Car> cars = new ArrayList<Car>();
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setMake(resultSet.getString("make"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getString("year"));
                car.setVin(resultSet.getString("VIN"));
                car.setClient(client);
                car.setOrders(new OrderDaoImpl().getOrdersListByCar(car));
                cars.add(car);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }
        return cars;
    }
}
