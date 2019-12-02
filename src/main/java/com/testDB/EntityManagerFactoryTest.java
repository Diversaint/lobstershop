package com.testDB;

import com.exception.RegisterException;
import com.model.City;
import com.model.Race;
import com.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class EntityManagerFactoryTest {
    public static void main(String[] args) {
        //org.apache.log4j.BasicConfigurator.configure();
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("lobstershop");

        EntityManager manager = managerFactory.createEntityManager();

        User user = new User("pudge9@mail.ua", "qwe123321", City.Wall, Race.dragon, new Date(), new Date(), new Date());

        EntityTransaction transaction = manager.getTransaction();

        Query query = manager.createQuery("SELECT u FROM User u WHERE u.email = :inEmail");

        List list = query.setParameter("inEmail", "pudge4@mail.ua")
                .setFirstResult(1)
                .setMaxResults(3)
                .getResultList();
        list.forEach(System.out::println);

        try {
            transaction.begin();
            String res = "";
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
