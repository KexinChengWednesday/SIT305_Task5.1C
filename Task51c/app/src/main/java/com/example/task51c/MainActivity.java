// MainActivity.java
package com.example.task51c;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;
import androidx.recyclerview.widget.GridLayoutManager;


public class MainActivity extends AppCompatActivity {

    RecyclerView rvTop, rvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTop = findViewById(R.id.rvTop);
        rvNews = findViewById(R.id.rvNews);

        List<NewsModel> topStories = getDummyData("Top");
        List<NewsModel> news = getDummyData("News");

        NewsAdapter topAdapter = new NewsAdapter(topStories, this::openNewsDetail);
        NewsAdapter newsAdapter = new NewsAdapter(news, this::openNewsDetail);

        rvTop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvTop.setAdapter(topAdapter);

        rvNews.setLayoutManager(new GridLayoutManager(this, 2));

        rvNews.setAdapter(newsAdapter);
    }

    private List<NewsModel> getDummyData(String type) {
        List<NewsModel> list = new ArrayList<>();
        if (type.equals("Top")) {
            list.add(new NewsModel("AI Breakthrough", R.drawable.ai_news, "Smarter World"));
            list.add(new NewsModel("SpaceX Launch", R.drawable.spacex, "50 satellites to orbit"));
            list.add(new NewsModel("Save Wildlife", R.drawable.wildlife, "Climate impact rising"));
        } else {
            list.add(new NewsModel("Local Hero Saves Cat", R.drawable.catrescue, "Rescue from tall tree"));
            list.add(new NewsModel("Tech Trends 2025", R.drawable.tech2025, "What to expect next"));
            list.add(new NewsModel("Explore Again", R.drawable.travel, "Travel post-pandemic"));
            list.add(new NewsModel("Wildlife Alert", R.drawable.wildlife, "Act to protect nature")); // ✅ 添加这条

        }
        return list;
    }

    private void openNewsDetail(NewsModel news) {
        NewsDetailFragment fragment = NewsDetailFragment.newInstance(news.title, news.imageResId, news.description);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        findViewById(R.id.mainScroll).setVisibility(View.GONE);
        findViewById(R.id.fragmentContainer).setVisibility(View.VISIBLE);
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
