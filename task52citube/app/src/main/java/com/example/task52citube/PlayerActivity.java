package com.example.task52citube;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.setWebViewClient(new WebViewClient());

        String fullUrl = getIntent().getStringExtra("url");
        String videoId = "";
        if (fullUrl != null && fullUrl.contains("v=")) {
            videoId = fullUrl.substring(fullUrl.indexOf("v=") + 2);
            int amp = videoId.indexOf("&");
            if (amp != -1) videoId = videoId.substring(0, amp);
        }

        webView.loadUrl("file:///android_asset/youtube_embed.html?v=" + videoId);
    }
}
