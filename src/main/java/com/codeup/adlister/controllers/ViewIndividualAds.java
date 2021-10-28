package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewIndividualAds", urlPatterns = "/ads/viewAd")
public class ViewIndividualAds extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") != null) {
            request.setAttribute("isLogin", true);//this attribute will decide whether or not the logout and profile will appear
            Ad currentAd = (Ad) request.getSession().getAttribute("ad");
            request.setAttribute("currentAd", currentAd);
            request.getRequestDispatcher("/WEB-INF/ads/viewAd.jsp").forward(request, response);
        }

        Ad currentAd = (Ad) request.getSession().getAttribute("ad");
        request.setAttribute("currentAd", currentAd);
        request.getRequestDispatcher("/WEB-INF/ads/viewAd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
