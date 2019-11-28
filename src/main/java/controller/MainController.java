package controller;

import exception.CartException;
import exception.InvalidLoginException;
import exception.RegisterException;
import exception.TicketException;
import model.Cart;
import model.Product;
import model.Ticket;
import model.User;

public interface MainController {

    User logIn(String email, String pass) throws InvalidLoginException;

    String registration(User user) throws RegisterException;

    Cart addToCart(Product product, User user) throws CartException;

    Ticket buy(Cart cart) throws TicketException;
}
