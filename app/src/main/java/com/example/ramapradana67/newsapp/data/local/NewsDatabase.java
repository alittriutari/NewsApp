package com.example.ramapradana67.newsapp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Rama Pradana on 1/28/2018.
 */
@Database(entities = {ArticlesItemEntity.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase{
    public abstract ArticlesItemDao articlesItemDao();
}
