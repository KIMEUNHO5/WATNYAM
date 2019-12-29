package com.forif.watnyam.data.naver;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.data.SearchService;
import com.forif.watnyam.model.NaverData;

import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverSearchClient {

    private static final String TAG = "NaverSearchClient";
    public static NaverSearchClient naverSearchClient;

    private MutableLiveData<List<NaverData>> NaverData = new MutableLiveData<>();
    private List<NaverData> NaverDataArrayList = new ArrayList<>();


    public static NaverSearchClient getInstance() {
        if (naverSearchClient == null) {
            naverSearchClient = new NaverSearchClient();
            return naverSearchClient;
        }
        return naverSearchClient;
    }

    public void getNaverResult() {
        SearchService naverSearchService = RetrofitInstanceBuilder.getNaverSearchService();

        Call<NaverSearchItemsModel> call = naverSearchService.getNaverSearchResult("Chicken", 20, 1, "sim");

        call.enqueue(new Callback<NaverSearchItemsModel>() {

            @Override
            public void onResponse(Call<NaverSearchItemsModel> call, Response<NaverSearchItemsModel> response) {
                Log.d(TAG, "OnResponse : " + response.code());
                Log.d(TAG, "OnResponse : " + response.body().getNaverSearchList().get(0));
            }

            @Override
            public void onFailure(Call<NaverSearchItemsModel> call, Throwable t) {
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
