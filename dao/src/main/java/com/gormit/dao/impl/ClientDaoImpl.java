package com.gormit.dao.impl;

import com.gormit.dao.ClientDao;
import com.gormit.pojos.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gormit on 17.09.2015.
 * Class works with methods unique to Client-entity implements ClientDao interface
 */
public class ClientDaoImpl extends DaoImpl<Client> implements ClientDao {

    private static final Logger logger = Logger.getLogger(ClientDaoImpl.class);


    /**
     * Method get Pageable List get from DB list of Clients with pagination
     * @param firstResult with rows begin
     * @param maxResult how many rows view
     * @return List of Clients with pagination
     */
    @Override
    public List<Client> getPageList(int firstResult, int maxResult) {

        String query = "SELECT * FROM client " + " limit " + firstResult + ", " + maxResult;
        List<Client> clients = new ArrayList<Client>();
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setSurname(resultSet.getString("surname"));
                client.setBirthday(resultSet.getDate("birthday"));
                client.setAddress(resultSet.getString("address"));
                client.setPhone(resultSet.getString("phone"));
                client.setMail(resultSet.getString("mail"));
                clients.add(client);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }
        return clients;
    }

    /**
     * Method get count all rows from table client
     * @return int count rows
     */
    @Override
    public int getCount() {
        int lastPage = 0;
        try {
            String query = "SELECT count(*) FROM client";
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                lastPage = resultSet.getInt("count(*)");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }

        return lastPage;
    }

    /**
     * Simple Save method, witch save Entity in DB
     * @param client - entity
     */
    @Override
    public void add(Client client) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        String sql = "INSERT INTO client (name, surname, birthday, address, phone, mail) " +
                "values ('" + client.getName() + "', '" + client.getSurname() + "', '" + formatter.format(client.getBirthday()) + "', '" + client.getAddress() + "', '" + client.getPhone() + "', '" + client.getMail() + "')";
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
     * @return Client or null
     */
    @Override
    public Client get(int id) {
        Client client = null;
        String query = "SELECT * FROM client WHERE id='" + id + "'";
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setSurname(resultSet.getString("surname"));
                client.setBirthday(resultSet.getDate("birthday"));
                client.setAddress(resultSet.getString("address"));
                client.setPhone(resultSet.getString("phone"));
                client.setMail(resultSet.getString("mail"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }

        return client;
    }

    /**
     * Method return from DB Entity by name and surname
     * @param name - Client name
     * @param surname - Client surname
     * @return Client or null
     */
    @Override
    public Client getClientByNameAndSurname(String name, String surname) {
        Client client = null;
        String query = "SELECT * FROM client WHERE name='" + name + "' and " + "surname ='" + surname + "'";
        try {
            Connection connection = DaoImpl.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setSurname(resultSet.getString("surname"));
                client.setBirthday(resultSet.getDate("birthday"));
                client.setAddress(resultSet.getString("address"));
                client.setPhone(resultSet.getString("phone"));
                client.setMail(resultSet.getString("mail"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.logger.error(e);
        }

        return client;
    }

    /* We do not user this method in our application, but must override it*/
    @Override
    public void update(Client client) {

    }

    /* We do not user this method in our application, but must override it*/
    @Override
    public void delete(Client client) {

    }
}
