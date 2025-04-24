package com.example.task52citube;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.task52citube.db.PlaylistDatabase;
import com.example.task52citube.db.PlaylistEntity;

public class HomeActivity extends AppCompatActivity {
    EditText etUrl;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = getIntent().getStringExtra("username");
        etUrl = findViewById(R.id.etUrl);

        findViewById(R.id.btnPlay).setOnClickListener(v -> {
            Intent i = new Intent(this, PlayerActivity.class);
            i.putExtra("url", etUrl.getText().toString());
            startActivity(i);
        });

        findViewById(R.id.btnAddToPlaylist).setOnClickListener(v -> {
            String url = etUrl.getText().toString();
            PlaylistEntity entry = new PlaylistEntity(username, url);
            PlaylistDatabase.getInstance(this).playlistDao().insert(entry);
            Toast.makeText(this, "Added to playlist", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnMyPlaylist).setOnClickListener(v -> {
            Intent i = new Intent(this, PlaylistActivity.class);
            i.putExtra("username", username);
            startActivity(i);
        });
    }
}