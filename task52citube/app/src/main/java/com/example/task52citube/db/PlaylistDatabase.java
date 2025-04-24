package com.example.task52citube.db;

import android.content.Context;
import androidx.room.*;

@Database(entities = {PlaylistEntity.class}, version = 1)
public abstract class PlaylistDatabase extends RoomDatabase {
    public abstract PlaylistDao playlistDao();

    private static PlaylistDatabase INSTANCE;

    public static PlaylistDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    PlaylistDatabase.class, "playlist_db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
