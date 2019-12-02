package com.controller;

import com.exception.AppException;
import com.exception.CartException;
import com.exception.RegisterException;
import com.exception.TicketException;
import com.model.Admin;
import com.model.Product;
import com.model.User;

import java.util.List;

public interface AdminController extends MainController {


    Product addProduct(Product product) throws AppException;

    User addUser(User user) throws RegisterException;

    Admin addAdmin(Admin admin) throws RegisterException;

    Admin addAdmin(User user) throws RegisterException;

    List showAll(Object show);



}
