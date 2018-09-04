package com.example.ramapradana67.newsapp.data.remote.model;

/**
 * Created by ramapradana67 on 14/01/18.
 */

public class NewsItem {

    private String urlImage;
    private String title;
    private String author;
    private String description;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
