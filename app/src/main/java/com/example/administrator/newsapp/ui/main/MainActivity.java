package com.example.administrator.newsapp.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //Todo 1 inisialisasi recyclerview dan adapter
    private NewsAdapter adapter;
    RecyclerView rvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new NewsAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(adapter);

    }

    //ToDo membuat data dummy untuk dimunculkan
    public List<NewsItem> getDummyData() {
        List<NewsItem> result= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NewsItem newsItem=new NewsItem();
            newsItem.setTitle("Judul "+String.valueOf(i));
            newsItem.setAuthor("Author "+String.valueOf(i));
            newsItem.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. "+String.valueOf(i));
            newsItem.setUrlCover("http://lorempixel.com/400/200/sports/"+String.valueOf(i));
            result.add(newsItem);
        }
        return result;

    }
}
