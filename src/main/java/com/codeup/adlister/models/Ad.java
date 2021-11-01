package com.codeup.adlister.models;

import java.nio.file.FileStore;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private Date date;

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    // added constructor to generate date data and this constructor targets userId as compared to the other constructor (actually using this constructor)
    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        java.util.Date date = new java.util.Date(); // instantiated methods and creating a new object?
        // java.sql.Date sqlDate = new Date(date.getTime());
//        java.sql.Date sqlDate = new java.sql.Date(util.date.get); // instantiated methods. what do i need to pass into the () to get the current date/time???
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        this.date = sqlDate; // added this to be able to add new ad to ad lister
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
