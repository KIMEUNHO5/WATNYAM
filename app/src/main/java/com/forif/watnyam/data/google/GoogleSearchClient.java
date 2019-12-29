package com.forif.watnyam.data.google;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.data.SearchService;
import com.forif.watnyam.model.GoogleData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.forif.watnyam.Config.GOOGLE_API_KEY;
import static com.forif.watnyam.Config.GOOGLE_SEARCH_ENGINE_ID;

public class GoogleSearchClient {

    private static final String TAG = "GoogleSearchClient";
    public static GoogleSearchClient googleSearchClient;

    private MutableLiveData<ArrayList<GoogleData>> mutableLiveData = new MutableLiveData<>();
    private ArrayList<GoogleData> googleDataArrayList = new ArrayList<>();

    public static GoogleSearchClient getInstance() {
        if(googleSearchClient == null){
            googleSearchClient = new GoogleSearchClient();
            return googleSearchClient;
        }
        return googleSearchClient;
    }

    public void getResult(String query){
        SearchService googleSearchService
        = RetrofitInstanceBuilder.getGoogleSearchService();

        Call<GoogleSearchModel> call =
        googleSearchService.getGoogleSearchResult(
                query + " image", GOOGLE_API_KEY, GOOGLE_SEARCH_ENGINE_ID, "json"
        );

        call.enqueue(new Callback<GoogleSearchModel>() {
            @Override
            public void onResponse(Call<GoogleSearchModel> call, Response<GoogleSearchModel> response) {
                Log.d(TAG, "onResponse: " + response.code());
//                Log.d(TAG, "onResponse: " + response.body().getItems().get(0).getThumbnails().getGoogleImageList().get(0).getSrc());

                if(response.code() == 200 && response.body().getItems() != null){
                        List<GoogleSearchResults> googleSearchResults = response.body().getItems();
                        for(int i = 0; i < googleSearchResults.size(); i++){
                            googleDataArrayList.add(new GoogleData(
                                    googleSearchResults.get(i).getTitle(),
                                    googleSearchResults.get(i).getSnippet(),
                                    googleSearchResults.get(i).getThumbnails().getGoogleImageList().get(0).getSrc()
                            ));
                        }
                }

                mutableLiveData.setValue(googleDataArrayList);
            }

            @Override
            public void onFailure(Call<GoogleSearchModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public MutableLiveData<ArrayList<GoogleData>> getMutableLiveData() {
        return mutableLiveData;
    }
}
