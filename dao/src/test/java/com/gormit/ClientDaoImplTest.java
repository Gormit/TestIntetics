package com.gormit;

import com.gormit.dao.impl.ClientDaoImpl;
import com.gormit.pojos.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Gormit on 21.09.2015.
 * Class fo testing ClientDaoImpl
 */
public class ClientDaoImplTest {

    private Client getTestClient() {
        Client client = new Client();
        client.setName("testName");
        client.setSurname("testSurname");
        client.setBirthday(new Date());
        client.setAddress("testAddress");
        client.setPhone("testPhone");
        client.setMail("test@mail.com");
        return client;
    }

    @Test
    public void testGet() throws Exception {
        Client testClient = getTestClient();
        new ClientDaoImpl().add(testClient);
        int id = testClient.getId();
        Client client = new ClientDaoImpl().get(id);
        Assert.assertEquals("Compare Client", testClient, client);
        new ClientDaoImpl().delete(testClient);

    }
}
