package com.forif.watnyam.data.naver;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.util.Log;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.data.SearchService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverSearchClient {

    private static final String TAG = "NaverSearchClient";
    public static NaverSearchClient naverSearchClient;

    public static NaverSearchClient getInstance() {
        if (naverSearchClient == null) {
            naverSearchClient = new NaverSearchClient();
            return naverSearchClient;
        }
        return naverSearchClient;
    }

    private void getNaverResult() {
        SearchService naverSearchService = RetrofitInstanceBuilder.getNaverSearchService();

        Call<NaverSearchModel> call = naverSearchService.getNaverSearchResult("Chicken", 20, 1, sim);

        call.enqueue(new Callback<NaverSearchModel>() {

            @Override
            public void onResponse(Call<NaverSearchModel> call, Response<NaverSearchModel> response) {
                Log.d(TAG, "OnResponse : " + response.code());
                Log.d(TAG, "OnResponse : " + response.body().getNaverSearchList().get(0));
            }

            @Override
            public void onFailure(Call<NaverSearchModel> call, Throwable t) {
                Log.d(TAG, "OnFailure " + t.getMessage());
            }
        });
    }

    class NaverAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

    public void executeNaver() {
        new NaverAsync().execute();
    }
}
