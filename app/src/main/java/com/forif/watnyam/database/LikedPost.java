package com.forif.watnyam.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "likedPostTable")
public class LikedPost {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "postTitle")
    private String postTitle;

    @ColumnInfo(name = "postLink")
    private String postLink;

    @ColumnInfo(name = "postThumbnail")
    private String postThumbnail;


    @NonNull
    public String getPostTitle() {
        return postTitle;
    }

    public String getPostLink() {
        return postLink;
    }

    public String getPostThumbnail() {
        return postThumbnail;
    }

    public LikedPost(@NonNull String postTitle, String postLink, String postThumbnail) {
        this.postTitle = postTitle;
        this.postLink = postLink;
        this.postThumbnail = postThumbnail;
    }
}
