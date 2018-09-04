package com.example.ramapradana67.newsapp.ui.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.example.ramapradana67.newsapp.R;
import com.example.ramapradana67.newsapp.data.remote.model.ApiResponse;
import com.example.ramapradana67.newsapp.data.remote.service.NewsApiClient;
import com.example.ramapradana67.newsapp.data.remote.service.NewsApiService;
import com.example.ramapradana67.newsapp.ui.detail.DetailActivity;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.rv_news)
    RecyclerView rvNews;
    NewsAdapter adapter;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private Call<ApiResponse> call;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        setupList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (call != null){
            call.cancel();
        }
    }

    private void setupList() {
        adapter = new NewsAdapter();

        adapter.setReadMoreListener(articlesItem -> {
            DetailActivity.start(MainActivity.this, articlesItem);

        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(adapter);

        loadData();
    }

    private void setupView() {

        ButterKnife.bind(this);


        swipeRefreshLayout.setOnRefreshListener(() -> loadData());

    }

    void loadData(){
        i++;

        swipeRefreshLayout.setRefreshing(true);
        if (i%2 == 0){
            call = NewsApiClient.getNewsApiSerive()
                    .getTopHeadlineNews("us");
        }else{
            call = NewsApiClient.getNewsApiSerive()
                    .getTopHeadlineNews("id");
        }


        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                adapter.setData(response.body().getArticles());
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ", t);
                swipeRefreshLayout.setRefreshing(false);

            }
        });


    }




}
