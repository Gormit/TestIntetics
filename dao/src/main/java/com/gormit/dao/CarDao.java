package com.gormit.dao;

import com.gormit.pojos.Car;
import com.gormit.pojos.Client;

import java.util.List;

/**
 * Created by Gormit on 18.09.2015.
 * Interface works with methods unique to Car-entity
 */
public interface CarDao extends Dao<Car> {

    /**
     * Method get Client's list of Cars
     * @param client - entity
     * @return List of Cars
     */
    List<Car> getCarListByClient(Client client);
}
