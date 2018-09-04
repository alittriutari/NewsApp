package com.example.ramapradana67.newsapp.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ramapradana67.newsapp.data.remote.model.ArticlesItem;

import java.util.List;

import retrofit2.http.DELETE;
import retrofit2.http.Url;

/**
 * Created by Rama Pradana on 1/28/2018.
 */
@Dao
public interface ArticlesItemDao {

    @Query("SELECT * FROM ArticlesItemEntity")
    List<ArticlesItemEntity> getAll();

    @Query("SELECT * FROM ArticlesItemEntity WHERE url = :url LIMIT 1")
    ArticlesItemEntity getByUrl(String url);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ArticlesItemEntity articlesItemEntities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ArticlesItemEntity>articlesItemEntitiesList);

    @Update
    void update(ArticlesItemEntity articlesItemEntity);

    @Delete
    void delete(ArticlesItemEntity articlesItemEntity);

    @Delete
    void deleteAll(List<ArticlesItemEntity> articlesItemEntities);
}
