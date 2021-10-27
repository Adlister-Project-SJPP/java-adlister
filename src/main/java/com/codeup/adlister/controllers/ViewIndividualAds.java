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
        Long singleAd = Long.parseLong(request.getParameter("singularAd"));
        Ad singularAd = DaoFactory.getAdsDao().selectAd(singleAd);
        request.setAttribute("singularAd", singularAd);
        request.getRequestDispatcher("/WEB-INF/ads/viewAd.jsp").forward(request, response);
    }
}