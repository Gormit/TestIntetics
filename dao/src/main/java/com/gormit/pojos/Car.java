package com.gormit.pojos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gormit on 17.09.2015.
 * Entity - Car.
 * Bean class for working with entity-Car
 */
public class Car implements Serializable {

    private static final long serialVersionUID = -751928108142797654L;

    private int id;
    private String make;
    private String model;
    private String year;
    private String vin;

    private Client client;

    private List<Order> orders;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (!make.equals(car.make)) return false;
        if (!model.equals(car.model)) return false;
        if (!year.equals(car.year)) return false;
        if (!vin.equals(car.vin)) return false;
        if (client != null ? !client.equals(car.client) : car.client != null) return false;
        return !(orders != null ? !orders.equals(car.orders) : car.orders != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + make.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + vin.hashCode();
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }
}
