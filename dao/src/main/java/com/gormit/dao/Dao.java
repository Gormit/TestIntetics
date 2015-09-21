package com.gormit.dao;



/**
 * Created by Gormit on 17.09.2015.
 * Interface with base operations to Entities
 */
public interface Dao<T> {

    /**
     * Simple Save method, witch save Entity in DB
     * @param t entity
     */
    void add(T t);

    /**
     * Simple Get method, witch return Entity from DB
     * @param id - ID Entity
     * @return Entity
     */
    T get(int id);

    /**
     * Simple update method, with update Entity by ID
     * @param t - entity
     */
    void update(T t);

    /**
     * Simple delete method, with delete Entity from DB
     * @param t - entity
     */
    void delete(T t);


}
