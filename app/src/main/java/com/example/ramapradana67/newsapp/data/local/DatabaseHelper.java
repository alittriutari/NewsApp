package com.example.ramapradana67.newsapp.data.local;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Rama Pradana on 1/28/2018.
 */

public class DatabaseHelper{
    private static final String DATABASE_NAME = "news_database";
    private static NewsDatabase INSTANCE;

    public static NewsDatabase getNewsDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, NewsDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
