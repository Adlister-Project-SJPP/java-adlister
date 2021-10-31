package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());

        if (request.getSession().getAttribute("user") != null) {
            request.setAttribute("isLogin", true);//this attribute will decide whether or not the logout and profile will appear
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ad_ID = req.getParameter("ad-ID");
        Long adLong = Long.valueOf(ad_ID);
        Ad ad = DaoFactory.getAdsDao().selectAd(adLong);
        req.getSession().setAttribute("ad", ad);

        resp.sendRedirect("/ads/viewAd");
    }
}
