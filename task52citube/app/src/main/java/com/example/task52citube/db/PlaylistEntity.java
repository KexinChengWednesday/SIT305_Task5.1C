package com.example.task52citube.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlaylistEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String user;
    public String url;

    public PlaylistEntity(String user, String url) {
        this.user = user;
        this.url = url;
    }
}
