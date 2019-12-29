package com.forif.watnyam.data.google;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.model.GoogleData;

import java.util.ArrayList;

public class GoogleRepository {

    private GoogleSearchClient googleSearchClient;
    private static GoogleRepository googleRepository;

    public static GoogleRepository getInstance() {
        if(googleRepository == null){
            googleRepository = new GoogleRepository();
        }
        return googleRepository;
    }

    public GoogleRepository() {
        googleSearchClient = GoogleSearchClient.getInstance();
    }

    public MutableLiveData<ArrayList<GoogleData>> getMutableLiveGoogleData(){
        return googleSearchClient.getMutableLiveData();
    }

    public void fetchGoogleResultAsync(String query){
        new GoogleAsync(query).execute();
    }

    class GoogleAsync extends AsyncTask<Void, Void, Void> {

        private String query;

        public GoogleAsync(String query){
            this.query = query;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            googleSearchClient.getResult(query);
            return null;
        }
    }



}
