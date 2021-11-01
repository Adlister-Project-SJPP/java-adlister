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

        request.getSession().getAttribute("ads");

        if(request.getSession().getAttribute("ads") == null) {
            request.getSession().setAttribute("ads", DaoFactory.getAdsDao().all());
        }

        if (request.getSession().getAttribute("user") != null) {
            request.setAttribute("isLogin", true);//this attribute will decide whether or not the logout and profile will appear
        }

        // If we have  search term, filter based on that, otherwise return all results
        String search = request.getParameter("searchTitle");
        if (search != null) {
            request.setAttribute("ads", DaoFactory.getAdsDao().searchAd(search));
        }
        else {
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
        }

        // Redirect to ads page
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String ad_ID = req.getParameter("ad-ID");
        Long adLong = Long.valueOf(ad_ID);
        Ad ad = DaoFactory.getAdsDao().selectAd(adLong);
        req.getSession().setAttribute("ad", ad);


        if(request.getParameter("sort-btn") != null) {
            if (getSelectValue.equals("newestToOld")) {
                request.getSession().setAttribute("ads", DaoFactory.getAdsDao().sortAdByDateAsc());
            } else if (request.getParameter("date").equals("oldestToNewest")) {
                request.getSession().setAttribute("ads", DaoFactory.getAdsDao().sortAdByDateDesc());
            }
            System.out.println(request.getParameter("sort-btn"));
            response.sendRedirect("/ads/viewAd");
    }

        String ad_ID = request.getParameter("ad-ID");
        Long adLong = Long.valueOf(ad_ID);
        Ad ad = DaoFactory.getAdsDao().selectAd(adLong);
        request.getSession().setAttribute("ad", ad);
        response.sendRedirect("/ads/viewAd");
    }
}
