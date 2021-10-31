package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import com.codeup.adlister.dao.MySQLAdsDao;
import com.mysql.cj.xdevapi.Statement;

import com.codeup.adlister.models.Ad;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        String search = request.getParameter("searchTitle");
            if (request.getSession().getAttribute("user") != null) {
                request.setAttribute("isLogin", true);//this attribute will decide whether or not the logout and profile will appear
                request.setAttribute("hasSearched", true);
                request.setAttribute("ads", DaoFactory.getAdsDao().searchAd(search));
                request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
            }

        if(search != null){
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request,response);
        }
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);

        String ad_ID = req.getParameter("ad-ID");
        Long adLong = Long.valueOf(ad_ID);
        Ad ad = DaoFactory.getAdsDao().selectAd(adLong);
        req.getSession().setAttribute("ad", ad);
        resp.sendRedirect("/ads/viewAd");

    }
}
