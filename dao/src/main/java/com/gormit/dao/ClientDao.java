package com.gormit.dao;

import com.gormit.pojos.Client;

import java.util.List;

/**
 * Created by Gormit on 17.09.2015.
 * Interface works with methods unique to Client-entity
 */
public interface ClientDao extends Dao<Client> {

    /**
     * Method get Pageable List get from DB list of Clients with pagination
     * @param firstResult with rows begin
     * @param maxResult how many rows view
     * @return List of Clients with pagination
     */
    List<Client> getPageList(int firstResult, int maxResult);

    /**
     * Method get count all rows from table client
     * @return int count rows
     */
    int getCount();

    /**
     * Method return from DB Entity by name and surname
     * @param name - Client name
     * @param surname - Client surname
     * @return Client or null
     */
    Client getClientByNameAndSurname(String name, String surname);
}
