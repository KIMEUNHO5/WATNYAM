package com.forif.watnyam.data.youtube;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.model.YoutubeData;

import java.util.ArrayList;

public class YoutubeRepository {

    private static YoutubeRepository youtubeRepository;
    private YoutubeSearchClient youtubeSearchClient;

    public YoutubeRepository(){
        youtubeSearchClient = YoutubeSearchClient.getInstance();
    }

    public static YoutubeRepository getInstance() {
        if(youtubeRepository == null){
            youtubeRepository = new YoutubeRepository();
        }
        return youtubeRepository;
    }

    public void fetchYoutubeData(String query){
        new YoutubeAsync(query).execute();
    }

    public MutableLiveData<ArrayList<YoutubeData>> getYoutubeMutableLiveData(){
        return youtubeSearchClient.getArrayListMutableLiveData();
    }


    class YoutubeAsync extends AsyncTask<Void, Void, Void> {

        private String query;

        public YoutubeAsync(String query){
            this.query = query;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            youtubeSearchClient.getYoutubeResult(query);
            return null;
        }
    }

}
