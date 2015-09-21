package com.gormit.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Gormit on 17.09.2015.
 * Connection pool used library c3p0
 */
public class DataSource {

    private static final Logger logger = Logger.getLogger(DataSource.class);
    private static DataSource datasource;
    private ComboPooledDataSource cpds;

    private DataSource() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(this.getClass().getClassLoader().getResource("logindb.properties").getFile());
            prop.load(input);
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver
            cpds.setJdbcUrl(prop.getProperty("dburl"));
            cpds.setUser(prop.getProperty("user"));
            cpds.setPassword(prop.getProperty("password"));

            // the settings below are optional -- c3p0 can work with defaults
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);
            cpds.setMaxStatements(180);
        } catch (PropertyVetoException e) {
            this.logger.error(e);
        } catch (FileNotFoundException e) {
            this.logger.error(e);
        } catch (IOException e) {
            this.logger.error(e);
        }

    }

    public static synchronized DataSource getInstance() {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }
}

