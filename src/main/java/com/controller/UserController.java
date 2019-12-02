package com.controller;


import com.exception.CartException;
import com.exception.TicketException;
import com.model.Cart;
import com.model.Product;
import com.model.Ticket;
import com.model.User;

public interface UserController extends MainController {


    Cart addToCart(Product product, User user) throws CartException;

    Ticket buy(Cart cart) throws TicketException;

}
