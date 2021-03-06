package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    Ad selectAd(Long ad);

    List<Ad> sortAdByDateAsc();
    List<Ad> sortAdByDateDesc();

    List<Ad> searchAd(String ad);
    Object userAds(long id);

    void updateAd(Ad ad);

    void deleteAd(long id);
}
