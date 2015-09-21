package com.gormit.pojos;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Gormit on 17.09.2015.
 * Entity - Order.
 * Bean class for working with entity-Order
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -750938108152796654L;

    private int id;
    private Date date;
    private double price;
    private String status;

    private Car car;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (Double.compare(order.price, price) != 0) return false;
        if (!date.equals(order.date)) return false;
        if (!status.equals(order.status)) return false;
        return !(car != null ? !car.equals(order.car) : order.car != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + date.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + status.hashCode();
        result = 31 * result + (car != null ? car.hashCode() : 0);
        return result;
    }
}
