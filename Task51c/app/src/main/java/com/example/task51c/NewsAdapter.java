package com.example.task51c;

import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final List<NewsModel> newsList;
    private final OnNewsClickListener listener;

    public interface OnNewsClickListener {
        void onClick(NewsModel news);
    }

    public NewsAdapter(List<NewsModel> newsList, OnNewsClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsModel news = newsList.get(position);
        holder.tvTitle.setText(news.title);
        holder.tvDesc.setText(news.description);
        holder.img.setImageResource(news.imageResId);
        holder.itemView.setOnClickListener(v -> listener.onClick(news));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc;
        ImageView img;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            img = itemView.findViewById(R.id.imgNews);
        }
    }
}