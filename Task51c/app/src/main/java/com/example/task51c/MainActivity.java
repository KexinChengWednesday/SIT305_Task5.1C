package com.example.task51c;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvTop = findViewById(R.id.rvTop);
        RecyclerView rvNews = findViewById(R.id.rvNews);

        // Top Stories 横向滑动
        rvTop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // News 区域为横向滑动宫格（2 行）
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        rvNews.setLayoutManager(gridLayoutManager);

        List<NewsModel> topStories = new ArrayList<>();
        topStories.add(new NewsModel("Top 1", "Top story 1", R.drawable.sample1));
        topStories.add(new NewsModel("Top 2", "Top story 2", R.drawable.sample2));
        topStories.add(new NewsModel("Top 3", "Top story 3", R.drawable.sample3));
        topStories.add(new NewsModel("Top 4", "Top story 4", R.drawable.sample4));

        List<NewsModel> newsList = new ArrayList<>();
        newsList.add(new NewsModel("9NEWS", "Latest headlines from 9News", R.drawable.sample1));
        newsList.add(new NewsModel("7NEWS", "Top updates from 7News", R.drawable.sample2));
        newsList.add(new NewsModel("ABC NEWS", "Trusted news from ABC", R.drawable.sample3));
        newsList.add(new NewsModel("THE AGE", "Business & sport in The Age", R.drawable.sample4));

        NewsAdapter topAdapter = new NewsAdapter(topStories, this::openNewsDetail);
        NewsAdapter newsAdapter = new NewsAdapter(newsList, this::openNewsDetail);

        rvTop.setAdapter(topAdapter);
        rvNews.setAdapter(newsAdapter);
    }

    private void openNewsDetail(NewsModel news) {
        NewsDetailFragment fragment = NewsDetailFragment.newInstance(
                news.getTitle(),
                news.getImageResId(),
                news.getDescription()
        );
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();

        // 切换可见性，隐藏主页，显示详情页
        findViewById(R.id.mainScroll).setVisibility(View.GONE);
        findViewById(R.id.fragmentContainer).setVisibility(View.VISIBLE);
    }
}
