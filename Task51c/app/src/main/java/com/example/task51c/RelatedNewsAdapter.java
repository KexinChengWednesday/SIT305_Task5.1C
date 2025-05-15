package com.example.task51c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.RelatedViewHolder> {

    private List<NewsModel> relatedNewsList;

    public RelatedNewsAdapter(List<NewsModel> relatedNewsList) {
        this.relatedNewsList = relatedNewsList;
    }

    @NonNull
    @Override
    public RelatedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_related_news, parent, false);
        return new RelatedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedViewHolder holder, int position) {
        NewsModel news = relatedNewsList.get(position);
        holder.tvTitle.setText(news.getTitle());
        holder.tvDesc.setText(news.getDescription());
        holder.imgRelated.setImageResource(news.getImageResId());
    }

    @Override
    public int getItemCount() {
        return relatedNewsList.size();
    }

    static class RelatedViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRelated;
        TextView tvTitle, tvDesc;

        public RelatedViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRelated = itemView.findViewById(R.id.imgRelated);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}
