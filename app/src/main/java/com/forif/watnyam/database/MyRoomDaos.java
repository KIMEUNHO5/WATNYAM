package com.forif.watnyam.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MyRoomDaos {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPost(LikedPost likedPost);

    @Query("DELETE FROM likedPostTable WHERE postTitle=:postTitle")
    void deleteByMovieId(String postTitle);

    @Query("SELECT * FROM likedPostTable")
    LiveData<List<LikedPost>> loadAllLikedPosts();

}
