package com.forif.watnyam.database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MyRoomRepo {

    private static final String TAG = "MyRoomRepo";

    private final MyRoomDaos daos;
    private static LikedPost likedPost;
    private static MyRoomRepo myRoomRepo;

    public static MyRoomRepo getInstance(Context context) {
        if(myRoomRepo == null){
            myRoomRepo = new MyRoomRepo(context);
        }
        return myRoomRepo;
    }

    public MyRoomRepo(Context context){
        MyRoomDB myRoomDB = MyRoomDB.getDatabase(context);
        daos = myRoomDB.daos();
    }

    public LiveData<List<LikedPost>> getLikedPostFromDatabase(){
        try {
            return new LoadLikedPostsAsync(daos).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertLikedPost(LikedPost likedPost){
        Log.d(TAG, "insertLikedPost: " + likedPost.getPostTitle());
        new InsertLikedPostAsync(daos).execute(likedPost);
    }


    public void deleteLikedPostByTitle(String postTitle){
        Log.d(TAG, "deleteLikedPostByTitle: " + postTitle);
        new DeleteLikedPostAsync(daos).execute(postTitle);
    }

    public static class InsertLikedPostAsync extends AsyncTask<LikedPost, Void, Void>{
        private final MyRoomDaos daos;

        InsertLikedPostAsync(MyRoomDaos daos){
            this.daos = daos;
        }

        @Override
        protected Void doInBackground(LikedPost... likedPosts) {
            Log.d(TAG, "doInBackground: inserting " + likedPosts + " in the database...");
            daos.insertPost(likedPosts[0]);
            return null;
        }
    }

    public static class DeleteLikedPostAsync extends AsyncTask<String, Void, Void>{
        private final MyRoomDaos daos;

        DeleteLikedPostAsync(MyRoomDaos daos){
            this.daos = daos;
        }

        @Override
        protected Void doInBackground(String ... strings) {
            Log.d(TAG, "doInBackground: deleting from the database...");
            daos.deleteByMovieId(strings[0]);
            return null;
        }
    }


    public static class LoadLikedPostsAsync extends AsyncTask<Void, Void, LiveData<List<LikedPost>>>{
        private final MyRoomDaos daos;

        LoadLikedPostsAsync(MyRoomDaos daos){
            this.daos = daos;
        }

        @Override
        protected LiveData<List<LikedPost>> doInBackground(Void... voids) {
            return daos.loadAllLikedPosts();
        }
    }
}
