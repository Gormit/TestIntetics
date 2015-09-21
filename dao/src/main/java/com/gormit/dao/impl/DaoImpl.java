package com.gormit.dao.impl;

import com.gormit.dao.Dao;
import com.gormit.util.DataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Gormit on 17.09.2015.
 * Abstract class witch get connection
 */
public abstract class DaoImpl<T> implements Dao<T> {

    private static final Logger logger = Logger.getLogger(DaoImpl.class);

    public static Connection getConnection() {

        try {
            return DataSource.getInstance().getConnection();
        } catch (SQLException e) {
            logger.error(e);
            return  null;
        }
    }
}
