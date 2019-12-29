package com.forif.watnyam.data.google;


import android.os.AsyncTask;
import android.util.Log;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.data.SearchService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.forif.watnyam.Config.GOOGLE_API_KEY;
import static com.forif.watnyam.Config.GOOGLE_SEARCH_ENGINE_ID;

public class GoogleSearchClient {

    private static final String TAG = "GoogleSearchClient";
    public static GoogleSearchClient googleSearchClient;

    public static GoogleSearchClient getInstance() {
        if(googleSearchClient == null){
            googleSearchClient = new GoogleSearchClient();
            return googleSearchClient;
        }
        return googleSearchClient;
    }

    private void getResult(){
        SearchService googleSearchService
        = RetrofitInstanceBuilder.getGoogleSearchService();

        Call<GoogleSearchModel> call =
        googleSearchService.getGoogleSearchResult(
                "Hamburger", GOOGLE_API_KEY, GOOGLE_SEARCH_ENGINE_ID, "json"
        );

        call.enqueue(new Callback<GoogleSearchModel>() {
            @Override
            public void onResponse(Call<GoogleSearchModel> call, Response<GoogleSearchModel> response) {
                Log.d(TAG, "onResponse: " + response.code());
                Log.d(TAG, "onResponse: " + response.body().getItems().get(0).getSnippet());

            }

            @Override
            public void onFailure(Call<GoogleSearchModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    class GoogleAsync extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            getResult();
            return null;
        }
    }

    public void executeGoogleAsync(){
        new GoogleAsync().execute();
    }
}
