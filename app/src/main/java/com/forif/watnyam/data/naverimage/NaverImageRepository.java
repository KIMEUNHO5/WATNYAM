package com.forif.watnyam.data.naverimage;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.model.NaverImageData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverImageRepository {

    private static NaverImageRepository naverImageRepository;
    private NaverImageClient naverImageClient;

    public static NaverImageRepository getInstance() {
        if(naverImageRepository == null){
            naverImageRepository = new NaverImageRepository();
        }
        return naverImageRepository;
    }

    public NaverImageRepository(){
        naverImageClient = NaverImageClient.getInstance();
    }

    public void fetchNaverImageResultAsync(String query){
        new NaverImageAsync(query).execute();
    }

    public MutableLiveData<ArrayList<NaverImageData>> getNaverImageData(){
        return naverImageClient.getMutableLiveData();
    }

    class NaverImageAsync extends AsyncTask<Void, Void, Void>{

        private String query;

        private NaverImageAsync(String query){
            this.query = query;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            naverImageClient.getNaverImageResult(query);
            return null;
        }
    }

}
