package com.testDB;

import com.exception.RegisterException;
import com.model.City;
import com.model.Race;
import com.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class EntityManagerFactoryTest {
    public static void main(String[] args) {
        org.apache.log4j.BasicConfigurator.configure();
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("lobstershop");

        EntityManager manager = managerFactory.createEntityManager();

        User user = new User("pudge4@mail.ua", "qwe123321", City.Wall, Race.dragon, new Date(), new Date(), new Date());

        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(user);
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        manager = managerFactory.createEntityManager();

        User userFinded = manager.find(User.class, 1L);

        System.out.println(userFinded);
    }
}
