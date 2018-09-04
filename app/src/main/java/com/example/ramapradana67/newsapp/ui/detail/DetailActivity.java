package com.example.ramapradana67.newsapp.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.ramapradana67.newsapp.R;
import com.example.ramapradana67.newsapp.data.local.ArticlesItemEntity;
import com.example.ramapradana67.newsapp.data.local.DatabaseHelper;
import com.example.ramapradana67.newsapp.data.local.NewsDatabase;
import com.example.ramapradana67.newsapp.data.remote.model.ArticlesItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ARTICLES_ITEM = "ARTICLES_ITEM";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.web_news)
    WebView web_news;
    @BindView(R.id.scroll_news)
    NestedScrollView scroll_news;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.progress_news)
    ProgressBar progressNews;

    NewsDatabase newsDatabase;
    ArticlesItemEntity byUrl;

    public static void start(Context context, ArticlesItem articlesItem) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_ARTICLES_ITEM, articlesItem);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        ButterKnife.bind(this);

        setupView();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void setupView() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ArticlesItem articlesItem = getIntent().getParcelableExtra(EXTRA_ARTICLES_ITEM);

        getSupportActionBar().setTitle(articlesItem.getTitle());
        getSupportActionBar().setSubtitle(articlesItem.getUrl());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);



        WebSettings settings = web_news.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(true);


        web_news.clearHistory();
        web_news.clearCache(true);
        web_news.setHorizontalScrollBarEnabled(true);
        web_news.setWebViewClient(new WebViewClient());
        web_news.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressNews.setVisibility(View.VISIBLE);
                progressNews.setProgress(newProgress);
                if (progressNews.getProgress() == newProgress) {
                    progressNews.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        web_news.loadUrl(articlesItem.getUrl());

        scroll_news.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (oldScrollY < scrollY){
                fab.hide();
            }else{
                fab.show();
            }
        });

        newsDatabase = DatabaseHelper.getNewsDatabase(getApplicationContext());
        byUrl = newsDatabase.articlesItemDao().getByUrl(articlesItem.getUrl());
        if (byUrl != null && byUrl.isFavorite()){
            fab.setImageResource(R.drawable.ic_action_fav);
        }else{
            fab.setImageResource(R.drawable.ic_fav_border);
        }

        fab.setOnClickListener(view -> {
            boolean fav = false;
            if (byUrl == null){
                ArticlesItemEntity newEntity = new ArticlesItemEntity(articlesItem);
                newEntity.setFavorite(true);
                newsDatabase.articlesItemDao().insert(newEntity);
                fav = true;
            }else{
                fav = !byUrl.isFavorite();
                byUrl.setFavorite(fav);
                newsDatabase.articlesItemDao().update(byUrl);
            }
            Snackbar.make(view, "Favorite Yey!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            if(fav){
                fab.setImageResource(R.drawable.ic_action_fav);
            }else{
                fab.setImageResource(R.drawable.ic_fav_border);
            }
        });
    }
}
