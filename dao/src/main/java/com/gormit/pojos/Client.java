package com.gormit.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Gormit on 17.09.2015.
 * Entity - Client.
 * Bean class for working with entity-Client
 */
public class Client implements Serializable {

    private static final long serialVersionUID = -750928108152897654L;

    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private String address;
    private String phone;
    private String mail;

    private List<Car> cars;

    public Client() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (!name.equals(client.name)) return false;
        if (!surname.equals(client.surname)) return false;
        if (!birthday.equals(client.birthday)) return false;
        if (!address.equals(client.address)) return false;
        if (!phone.equals(client.phone)) return false;
        if (!mail.equals(client.mail)) return false;
        return !(cars != null ? !cars.equals(client.cars) : client.cars != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + mail.hashCode();
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        return result;
    }
}
