package com.forif.watnyam.data.naver;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.data.SearchService;
import com.forif.watnyam.model.NaverData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverSearchClient {

    private static final String TAG = "NaverSearchClient";
    public static NaverSearchClient naverSearchClient;

    private MutableLiveData<ArrayList<NaverData>> mutableLiveData = new MutableLiveData<>();
    private ArrayList<NaverData> naverDataArrayList = new ArrayList<>();


    public static NaverSearchClient getInstance() {
        if (naverSearchClient == null) {
            naverSearchClient = new NaverSearchClient();
            return naverSearchClient;
        }
        return naverSearchClient;
    }

    public void getNaverResult(String query) {
        SearchService naverSearchService
                = RetrofitInstanceBuilder.getNaverSearchService();

        Call<NaverSearchItemsModel> call
                = naverSearchService.getNaverSearchResult(query, 20, 1, "sim");

        call.enqueue(new Callback<NaverSearchItemsModel>() {

            @Override
            public void onResponse(Call<NaverSearchItemsModel> call, Response<NaverSearchItemsModel> response) {
                Log.d(TAG, "onResponse: " + response.code());

                if(response.body() != null) {
                    List<NaverSearchResults> naverSearchList = response.body().getNaverSearchList();
                    for(int i = 0; i < naverSearchList.size(); i++){
                        naverDataArrayList.add(new NaverData(
                                naverSearchList.get(i).getTitle(),
                                naverSearchList.get(i).getLink(),
                                naverSearchList.get(i).getDescription()
                        ));
                    }

                    mutableLiveData.setValue(naverDataArrayList);
                }
            }

            @Override
            public void onFailure(Call<NaverSearchItemsModel> call, Throwable t) {
                Log.d(TAG, "OnFailure " + t.getMessage());
            }
        });
    }

    public MutableLiveData<ArrayList<NaverData>> getMutableLiveData() {
        return mutableLiveData;
    }
}
