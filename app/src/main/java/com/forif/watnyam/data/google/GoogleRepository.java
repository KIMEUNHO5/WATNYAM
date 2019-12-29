package com.forif.watnyam.data.google;

import android.os.AsyncTask;

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

    public void fetchGoogleResultAsync(){
        new GoogleAsync(googleSearchClient).execute();
    }

    class GoogleAsync extends AsyncTask<Void, Void, Void> {

        GoogleSearchClient googleSearchClient;

        public GoogleAsync(GoogleSearchClient googleSearchClient){
            this.googleSearchClient = googleSearchClient;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            googleSearchClient.getResult();
            return null;
        }
    }



}
