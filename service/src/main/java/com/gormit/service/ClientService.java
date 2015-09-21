package com.gormit.service;

import com.gormit.dao.impl.ClientDaoImpl;
import com.gormit.pojos.Client;

import java.util.List;

/**
 * Created by Gormit on 18.09.2015.
 * ClientService class for work with ClientDaoImpl
 */
public class ClientService {

    /**
     * Method send to UserDaoImpl a current page, how many rows must be on page
     * @param currentPage it is a current page
     * @param countRows how many rows must be on page
     * @return List of Users with pagination
     */
    public List<Client> getPageList(int currentPage, int countRows) {
        int firstResult = (currentPage - 1) * countRows;
        return new ClientDaoImpl().getPageList(firstResult, countRows);
    }

    /**
     * Get from UserDaoImpl count all rows in DB
     * @return count rows
     */
    public int getCount() {
        return new ClientDaoImpl().getCount();
    }

    /**
     * Send to UserDaoImpl a Client to save it
     * @param client
     */
    public void addClient(Client client){
        new ClientDaoImpl().add(client);
    }

    /**
     * Send to UserDaoImpl a Client name and surname, to search this Client
     * @param name - Client name
     * @param surname - Client surname
     * @return Client or null
     */
    public Client getClientByNameAndSurname(String name, String surname) {
        return new ClientDaoImpl().getClientByNameAndSurname(name, surname);
    }

    /**
     * Send to UserDaoImpl id, to search a Client
     * @param clientId - Client ID
     * @return Client or null
     */
    public Client getClientById(int clientId) {
        return new ClientDaoImpl().get(clientId);
    }

}

