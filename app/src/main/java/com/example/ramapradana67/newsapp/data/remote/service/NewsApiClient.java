package com.example.ramapradana67.newsapp.data.remote.service;

import com.google.gson.Gson;

import javax.xml.transform.OutputKeys;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rama Pradana on 1/27/2018.
 */

public class NewsApiClient {
    private static NewsApiService INSTANCE;

    public static NewsApiService getNewsApiSerive(){
        if (INSTANCE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();

            INSTANCE = retrofit.create(NewsApiService.class);
        }

        return INSTANCE;
    }

    public static OkHttpClient getOkHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(chain -> {
                    Request originalRequest = chain.request();
                    HttpUrl originalUrl = originalRequest.url();
                    HttpUrl newUrl = originalUrl.newBuilder()
                            .addQueryParameter("apiKey", "b02a718071f74770b99cd45a97b8bc0d")
                            .build();
                    Request newRequest = originalRequest.newBuilder()
                            .url(newUrl)
                            .build();
                    return chain.proceed(newRequest);

                })
                .build();
    }
}
