package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.editAd", urlPatterns = "/editAd")
public class editAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String adIdString = request.getParameter("adId");
        long adId = Long.valueOf(adIdString);

        Ad ad = DaoFactory.getAdsDao().selectAd(adId);
        ad.setTitle(title);
        ad.setDescription(description);

        DaoFactory.getAdsDao().updateAd(ad);

        response.sendRedirect("/profile");

    }
}
