package com.example.administrator.newsapp.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private List<NewsItem> dataSet=new ArrayList<>();

    //ToDo ketik ButterKnife.bind(this); lalu tekan alt+insert, pilih implemen method

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //Todo buat class view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.rvNews)
        RecyclerView rvNews;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.btn_readMore)
        Button btnReadMore;

        //Todo jika error merah, klik tombol merahnya, pilih create constructor matching super
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }



    }

}
