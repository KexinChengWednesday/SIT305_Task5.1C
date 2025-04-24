package com.example.task52citube.db;

import androidx.room.*;
import java.util.List;

@Dao
public interface PlaylistDao {
    @Insert
    void insert(PlaylistEntity entity);

    @Query("SELECT * FROM PlaylistEntity WHERE user = :user")
    List<PlaylistEntity> getByUser(String user);
}
