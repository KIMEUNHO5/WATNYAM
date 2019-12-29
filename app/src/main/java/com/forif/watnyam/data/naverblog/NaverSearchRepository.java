package com.forif.watnyam.data.naverblog;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.model.NaverData;

import java.util.ArrayList;

public class NaverSearchRepository {

    private NaverSearchClient naverSearchClient;
    private static NaverSearchRepository naverSearchRepository;

    public static NaverSearchRepository getInstance() {
        if(naverSearchRepository == null){
            naverSearchRepository = new NaverSearchRepository();
        }
        return naverSearchRepository;
    }

    public NaverSearchRepository() {
        naverSearchClient = naverSearchClient.getInstance();
    }

    public void fetchNaverResultAsync(String query){
        new NaverAsync(query).execute();
    }

    class NaverAsync extends AsyncTask<Void, Void, Void> {

        private String query;

        public NaverAsync(String query){
            this.query = query;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            naverSearchClient.getNaverResult(query);
            return null;
        }
    }

    public MutableLiveData<ArrayList<NaverData>> getMutableLiveNaverData(){
        return naverSearchClient.getMutableLiveData();
    }

}
