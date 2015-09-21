package com.gormit.dao;

import com.gormit.pojos.Car;
import com.gormit.pojos.Order;

import java.util.List;

/**
 * Created by Gormit on 19.09.2015.
 * Interface works with methods unique to Order-entity
 */
public interface OrderDao extends Dao<Order> {

    /**
     * Method get Car's list of Orders
     * @param car - entity
     * @return List of Orders
     */
    List<Order> getOrdersListByCar(Car car);
}
