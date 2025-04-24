package com.example.task51c;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class NewsDetailFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_IMAGE = "image";
    private static final String ARG_DESC = "desc";

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView tvTitle = view.findViewById(R.id.tvDetailTitle);
        TextView tvDesc = view.findViewById(R.id.tvDetailDesc);
        ImageView img = view.findViewById(R.id.imgDetail);
        RecyclerView rvRelated = view.findViewById(R.id.rvRelated);
        Button btnClose = view.findViewById(R.id.btnClose);

        tvTitle.setText(getArguments().getString(ARG_TITLE));
        tvDesc.setText(getArguments().getString(ARG_DESC));
        img.setImageResource(getArguments().getInt(ARG_IMAGE));

        List<NewsModel> relatedNews = new ArrayList<>();
        int[] imgs = {R.drawable.catrescue, R.drawable.travel, R.drawable.tech2025, R.drawable.spacex};
        for (int i = 0; i < imgs.length; i++) {
            relatedNews.add(new NewsModel("Related " + (i + 1), imgs[i], "Desc " + (i + 1)));
        }

        rvRelated.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        rvRelated.setAdapter(new RelatedNewsAdapter(relatedNews));

        btnClose.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
            requireActivity().findViewById(R.id.mainScroll).setVisibility(View.VISIBLE);
            requireActivity().findViewById(R.id.fragmentContainer).setVisibility(View.GONE);
        });
    }
}