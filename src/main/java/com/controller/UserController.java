package com.controller;

import com.exception.CartException;
import com.exception.InvalidLoginException;
import com.exception.RegisterException;
import com.exception.TicketException;
import com.model.Cart;
import com.model.Product;
import com.model.Ticket;
import com.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserController implements IUserControllerI {

    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("lobstershop");

    EntityManager manager = managerFactory.createEntityManager();

    EntityTransaction transaction = manager.getTransaction();

    @Override
    public Cart addToCart(Product product, User user) throws CartException {
        return null;
    }

    @Override
    public Ticket buy(Cart cart) throws TicketException {
        return null;
    }

    @Override
    public User logIn(String email, String pass) throws InvalidLoginException {
        return null;
    }

    @Override
    public String registration(User user) throws RegisterException {

        try {
            transaction.begin();
            manager.persist(user);
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
            return e.getMessage();
        } finally {
            manager.close();
        }

        return "User create";
    }
}
