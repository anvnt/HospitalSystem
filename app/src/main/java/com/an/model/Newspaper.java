package com.an.model;

import java.io.Serializable;
import java.util.Date;

public class Newspaper implements Serializable {
    private int image;
    private String title;
    private String description;
    private String source;

    public Newspaper() {
    }

    private Date date;

    public Newspaper(int image, String title, String description, String source, Date date) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.source = source;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
