package com.forif.watnyam.data.naver;

import android.os.AsyncTask;

public class NaverSearchRepository {

    private NaverSearchClient NaverSearchClient;
    private static NaverSearchRepository NaverSearchRepository;

    public static NaverSearchRepository getInstance() {
        if(NaverSearchRepository == null){
            NaverSearchRepository = new NaverSearchRepository();
        }
        return NaverSearchRepository;
    }

    public NaverSearchRepository() {
        NaverSearchClient = NaverSearchClient.getInstance();
    }

    public void fetchNaverResultAsync(){
        new NaverAsync(NaverSearchClient).execute();
    }

    class NaverAsync extends AsyncTask<Void, Void, Void> {

        NaverSearchClient NaverSearchClient;

        public NaverAsync(NaverSearchClient naverSearchClient){
            this.NaverSearchClient = NaverSearchClient;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            NaverSearchClient.getNaverResult();
            return null;
        }
    }

}
