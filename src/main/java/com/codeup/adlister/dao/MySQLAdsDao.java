package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM ads");
            ResultSet resultSet = statement.executeQuery();
            return createAdsFromResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> userAds(long id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            return createAdsFromResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public void updateAd(Ad ad) {
        String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ad.getTitle());
            statement.setString(2, ad.getDescription());
            statement.setLong(3,  ad.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ad", e);
        }
    }

    @Override
    public void deleteAd(long id) {
        String query = "DELETE  FROM ads WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1,  id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error delete ad", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, date) VALUES (?, ?, ?, ?)"; // added date to insert query
            PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, ad.getUserId());
            statement.setString(2, ad.getTitle());
            statement.setString(3, ad.getDescription());
            statement.setDate(4, ad.getDate()); // added this for date
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet resultSet) throws SQLException {
        return new Ad(
            resultSet.getLong("id"),
            resultSet.getLong("user_id"),
            resultSet.getString("title"),
            resultSet.getString("description")
        );
    }

    // method to sort through ads by date (ascending)
    public List<Ad> sortAdByDateAsc() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM ads ORDER BY date ASC");
            ResultSet resultSet = statement.executeQuery();
            return createAdsFromResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    // method to sort through ads by date (descending)
    public List<Ad> sortAdByDateDesc() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM ads ORDER BY date DESC");
            ResultSet resultSet = statement.executeQuery();
            return createAdsFromResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    private List<Ad> createAdsFromResults(ResultSet resultSet) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (resultSet.next()) {
            ads.add(extractAd(resultSet));
        }
        return ads;
    }
    @Override
//    method for the query selector of the searched value for ads
    public List<Ad> searchAd(String ad) {
        String query = "SELECT * FROM ads WHERE title LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,"%"+ ad + "%");
            ResultSet resultSet = statement.executeQuery();
            return createAdsFromResults(resultSet);
        }catch (SQLException e){
            throw new RuntimeException("Error finding the searched name", e);
        }
    }
    @Override
    public Ad selectAd(Long ad) {
        String query = "SELECT * FROM ads WHERE id  = ? LIMIT 1";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, ad);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return extractAd(resultSet);
        }catch (SQLException e){
            throw new RuntimeException("Error finding ad ID", e);
        }
    }
}
