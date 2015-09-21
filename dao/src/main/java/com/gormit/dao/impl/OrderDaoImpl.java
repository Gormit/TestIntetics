package com.gormit.dao.impl;

import com.gormit.dao.OrderDao;
import com.gormit.pojos.Car;
import com.gormit.pojos.Order;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gormit on 19.09.2015.
 * Class works with methods unique to Order-entity implements OrderDao interface
 */
public class OrderDaoImpl extends DaoImpl<Order> implements OrderDao {

    private static final Logger logger = Logger.getLogger(OrderDaoImpl.class);

    /**
     * Method get Car's list of Orders
     * @param car - entity
     * @return List of Orders
     */
    @Override
    public List<Order> getOrdersListByCar(Car car) {
        String query = "SELECT * FROM `order` WHERE car_id=" + car.getId();
        List<Order> orders = new ArrayList<Order>();
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setDate(resultSet.getDate("date"));
                order.setPrice(resultSet.getDouble("price"));
                order.setStatus(resultSet.getString("status"));
                order.setCar(car);
                orders.add(order);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }
        return orders;
    }

    /**
     * Simple Save method, witch save Entity in DB
     * @param order - entity
     */
    @Override
    public void add(Order order) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        String sql = "INSERT INTO `order` (date, price, status, car_id) " +
                "values ('" + formatter.format(order.getDate()) + "', '" + order.getPrice() + "', '" + order.getStatus() + "', '" + order.getCar().getId() + "')";
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
     * @return Order-entity
     */
    @Override
    public Order get(int id) {
        Order order = null;
        String query = "SELECT * FROM `order` WHERE id='" + id + "'";
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setDate(resultSet.getDate("date"));
                order.setPrice(resultSet.getDouble("price"));
                order.setStatus(resultSet.getString("status"));
                order.setCar(new CarDaoImpl().get(resultSet.getInt("car_id")));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }

        return order;
    }

    /**
     * Simple update method, with update Entity by ID
     * @param order - entity
     */
    @Override
    public void update(Order order) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        String query = "UPDATE `order` SET date='" + formatter.format(order.getDate()) + "', price='" + order.getPrice() + "', status='" + order.getStatus() + "' WHERE  id=" + order.getId();
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
     * @param order - entity
     */
    @Override
    public void delete(Order order) {
        String query = "DELETE FROM `order` WHERE id=" + order.getId();
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
}
