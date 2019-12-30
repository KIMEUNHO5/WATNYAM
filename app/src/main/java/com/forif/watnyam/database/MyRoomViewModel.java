package com.forif.watnyam.database;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class MyRoomViewModel extends AndroidViewModel {

    private static final String TAG = "MyRoomViewModel";
    private final MyRoomRepo myRoomRepo;

    public MyRoomViewModel(@NonNull Application application) {
        super(application);
        Log.d(TAG, "MyRoomViewModel: constructor running ... ");
        myRoomRepo = new MyRoomRepo(application);
    }

    public LiveData<List<LikedPost>> getLikedPostsLiveDataFromRepo(){
        return myRoomRepo.getLikedPostFromDatabase();
    }

    public void insertLikedPostViaViewModel(LikedPost likedMovie){
        myRoomRepo.insertLikedPost(likedMovie);
    }

    public void deleteLikedPostByTitleViaViewModel(String postTitle){
        myRoomRepo.deleteLikedPostByTitle(postTitle);
    }

    @NonNull
    @Override
    public <T extends Application> T getApplication() {
        return super.getApplication();
    }
}
