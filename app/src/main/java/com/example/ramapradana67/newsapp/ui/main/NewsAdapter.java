package com.example.ramapradana67.newsapp.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ramapradana67.newsapp.R;
import com.example.ramapradana67.newsapp.data.remote.model.ArticlesItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ramapradana67 on 14/01/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


    private List<ArticlesItem> dataset = new ArrayList<>();
    private ReadMoreListener readMoreListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //infate layout menjadi view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);


        //dibuatkan view holder
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ArticlesItem articlesItem = dataset.get(position);
        holder.tvTitle.setText(articlesItem.getTitle());
        holder.tvAuthor.setText(articlesItem.getAuthor());
        holder.tvNews.setText(articlesItem.getDescription());
        holder.btnReadMore.setOnClickListener(view -> {
            if (readMoreListener != null){
                readMoreListener.onReadMore(articlesItem);
            }
        });
        Glide.with(holder.itemView.getContext())
                .load(articlesItem.getUrlToImage())
                .into(holder.ivCover);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setData(List<ArticlesItem> newsItemsList) {
        this.dataset = newsItemsList;
        notifyDataSetChanged();
    }

    public void clearData() {
        this.dataset = Collections.emptyList();
        notifyDataSetChanged();
    }

    public void setReadMoreListener(ReadMoreListener readMoreListener){
        this.readMoreListener = readMoreListener;
    }

    public interface ReadMoreListener{
        void onReadMore(ArticlesItem articlesItem);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.tv_news)
        TextView tvNews;
        @BindView(R.id.btn_read_more)
        Button btnReadMore;
        @BindView(R.id.iv_cover)
        ImageView ivCover;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
