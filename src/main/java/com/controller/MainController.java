package com.controller;

import com.exception.CartException;
import com.exception.InvalidLoginException;
import com.exception.RegisterException;
import com.exception.TicketException;
import com.model.Cart;
import com.model.Product;
import com.model.Ticket;
import com.model.User;

public interface MainController {

    User logIn(String email, String pass) throws InvalidLoginException;

    String registration(User user) throws RegisterException;

}
