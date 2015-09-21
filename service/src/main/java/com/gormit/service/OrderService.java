package com.gormit.service;

import com.gormit.dao.impl.OrderDaoImpl;
import com.gormit.pojos.Car;
import com.gormit.pojos.Order;

import java.util.List;

/**
 * Created by Gormit on 19.09.2015.
 * OrderService class for work with OrderDaoImpl
 */
public class OrderService {

    /**
     * Send to OrderDaoImpl a Car to search List of Order by this Car
     * @param car - entity
     * @return List of Orders
     */
    public List<Order> getOrderListByCar(Car car) {
        return new OrderDaoImpl().getOrdersListByCar(car);
    }

    /**
     * Send to OrderDaoImpl an Order
     * if Order has ID - update
     * if Order has no ID - save
     * @param order - Entity
     */
    public void saveOrUpdate(Order order) {
        if (0 != order.getId()){
            new OrderDaoImpl().update(order);
        } else {
            new OrderDaoImpl().add(order);
        }
    }

    /**
     * Send to OrderDaoImpl id, to search an Order
     * @param orderId - Order ID
     * @return Order or null
     */
    public Order getOrderById(int orderId) {
        return new OrderDaoImpl().get(orderId);
    }

    /**
     * Send to OrderDaoImpl a Order, to delete it
     * @param order - entity
     */
    public void dellOrder(Order order) {
        new OrderDaoImpl().delete(order);
    }
}
