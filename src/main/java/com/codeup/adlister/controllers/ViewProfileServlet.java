
package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") != null) {
            request.setAttribute("isLogin", true);//This attribute will decide whether or not the logout and profile will appear
            User user = (User)request.getSession().getAttribute("user");//Getting the current user information
            User currentUser = DaoFactory.getUsersDao().findById(user.getId());//gets the id from the current user
            request.setAttribute("user",currentUser);//This set currentUser to user
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
        response.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String id = request.getParameter("id");//Captures the from the form as a String
        long userId = Long.valueOf(id);//Converts id from a string to a long

        User user =  DaoFactory.getUsersDao().findById(userId);//We use the DaoFactory to find the user by id then we filled in with the new username and email.
        user.setUsername(username);
        user.setEmail(email);

//        System.out.println(user.getId(userId));
        DaoFactory.getUsersDao().updateUser(user);// This updates the user information

        response.sendRedirect("/profile");

    }
}