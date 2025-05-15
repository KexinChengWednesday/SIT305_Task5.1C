package com.example.task51c;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_IMAGE = "image";
    private static final String ARG_DESC = "desc";

    private String title;
    private String desc;
    private int imageResId;
    private List<NewsModel> relatedNews = new ArrayList<>();

    public static NewsDetailFragment newInstance(String title, int imageResId, String desc) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putInt(ARG_IMAGE, imageResId);
        args.putString(ARG_DESC, desc);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            desc = getArguments().getString(ARG_DESC);
            imageResId = getArguments().getInt(ARG_IMAGE);
        }

        ImageView imgDetail = view.findViewById(R.id.imgDetail);
        TextView tvTitle = view.findViewById(R.id.tvDetailTitle);
        TextView tvDesc = view.findViewById(R.id.tvDetailDesc);
        Button btnClose = view.findViewById(R.id.btnClose);
        RecyclerView rvRelated = view.findViewById(R.id.rvRelated);

        imgDetail.setImageResource(imageResId);
        tvTitle.setText(title);
        tvDesc.setText(desc);

        int[] imgs = {R.drawable.sample1, R.drawable.sample2, R.drawable.sample3, R.drawable.sample4};
        for (int i = 0; i < 3; i++) {
            relatedNews.add(new NewsModel("Related " + (i + 1), "This is related news " + (i + 1), imgs[i]));
        }

        rvRelated.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRelated.setAdapter(new RelatedNewsAdapter(relatedNews));

        btnClose.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();

            // 恢复主页显示，隐藏详情页
            requireActivity().findViewById(R.id.mainScroll).setVisibility(View.VISIBLE);
            requireActivity().findViewById(R.id.fragmentContainer).setVisibility(View.GONE);
        });
    }
}
