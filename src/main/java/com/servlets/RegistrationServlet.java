package com.servlets;

import com.controller.UserController;
import com.exception.RegisterException;
import com.model.City;
import com.model.Race;
import com.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameterMap().size() > 2) {
            User user = new User(
                    request.getParameter("email"),
                    request.getParameter("password"),
                    City.valueOf(request.getParameter("city")),
                    Race.valueOf(request.getParameter("race")));
            UserController controller = new UserController();
            try {
                response.getWriter().write(controller.registration(user));
                //request.setAttribute("login", user.getLogin());
                RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
                rd.forward(request, response);
                            } catch (RegisterException e) {
                e.printStackTrace();
            }
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
