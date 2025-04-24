package com.example.task52citube;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.task52citube.db.PlaylistDatabase;
import com.example.task52citube.db.PlaylistEntity;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        String user = getIntent().getStringExtra("username");
        TextView tvList = findViewById(R.id.tvPlaylist);
        List<PlaylistEntity> list = PlaylistDatabase.getInstance(this).playlistDao().getByUser(user);

        StringBuilder sb = new StringBuilder();
        for (PlaylistEntity e : list) {
            sb.append(e.url).append("\n");
        }
        tvList.setText(sb.toString());
    }
}
