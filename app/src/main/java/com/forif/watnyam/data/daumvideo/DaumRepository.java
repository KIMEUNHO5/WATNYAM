package com.forif.watnyam.data.daumvideo;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.model.DaumVideoData;
import com.forif.watnyam.model.GoogleData;

import java.util.ArrayList;

public class DaumRepository {

    private DaumVideoClient daumVideoClient;
    private static DaumRepository daumRepository;

    public static DaumRepository getInstance() {
        if(daumRepository== null){
            daumRepository = new DaumRepository();
        }
        return daumRepository;
    }

    public DaumRepository() {
        daumVideoClient = DaumVideoClient.getInstance();
    }

    public MutableLiveData<ArrayList<DaumVideoData>> getMutableLiveDaumVideoData(){
        return daumVideoClient.getMutableLiveData();
    }

    public void fetchDaumResultAsync(String query){
        new DaumAsync(query).execute();
    }

    class DaumAsync extends AsyncTask<Void, Void, Void> {

        private String query;

        public DaumAsync(String query){
            this.query = query;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            daumVideoClient.getResult(query);
            return null;
        }
    }



}
