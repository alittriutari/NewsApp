package com.example.ramapradana67.newsapp.data.remote.service;

import com.example.ramapradana67.newsapp.data.remote.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rama Pradana on 1/27/2018.
 */

public interface NewsApiService {
    @GET("top-headlines")
    Call<ApiResponse> getTopHeadlineNews(@Query("country") String country);
}

