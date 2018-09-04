package com.example.ramapradana67.newsapp.data.local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.ramapradana67.newsapp.data.remote.model.ArticlesItem;

/**
 * Created by Rama Pradana on 1/28/2018.
 */

@Entity
public class ArticlesItemEntity {

    @PrimaryKey
    @NonNull
    private String url;

    private String publishedAt;

    private String author;

    private String urlToImage;

    private String description;

    private String title;

    private boolean favorite;

    public ArticlesItemEntity(){

    }

    public ArticlesItemEntity(ArticlesItem articlesItem){
        this.author = articlesItem.getAuthor();
        this.publishedAt = articlesItem.getPublishedAt();
        this.url = articlesItem.getUrl();
        this.description = articlesItem.getDescription();
        this.urlToImage = articlesItem.getUrlToImage();
        this.title = articlesItem.getTitle();
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
