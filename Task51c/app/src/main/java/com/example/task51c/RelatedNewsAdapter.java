package com.example.task51c;

import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {
    private final List<NewsModel> relatedNewsList;

    public RelatedNewsAdapter(List<NewsModel> relatedNewsList) {
        this.relatedNewsList = relatedNewsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_related_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsModel news = relatedNewsList.get(position);
        holder.tvTitle.setText(news.title);
        holder.tvDesc.setText(news.description);
        holder.img.setImageResource(news.imageResId);
    }

    @Override
    public int getItemCount() {
        return relatedNewsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc;
        ImageView img;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            img = itemView.findViewById(R.id.imgRelated);
        }
    }
}
