package com.forif.watnyam.data.youtube;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.data.SearchService;
import com.forif.watnyam.model.YoutubeData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.forif.watnyam.Config.YOUTUBE_API_KEY;

public class YoutubeSearchClient {
    private static final String TAG = "YoutubeSearchClient";
    private static YoutubeSearchClient youtubeSearchClient;

    private ArrayList<YoutubeData> youtubeDataArrayList = new ArrayList<>();
    private MutableLiveData<ArrayList<YoutubeData>> arrayListMutableLiveData = new MutableLiveData<>();

    public static YoutubeSearchClient getInstance() {
        if(youtubeSearchClient == null){
            youtubeSearchClient = new YoutubeSearchClient();
        }
        return youtubeSearchClient;
    }

    public void getYoutubeResult(String query){
        SearchService searchService = RetrofitInstanceBuilder.getYoutubeSearchService();
        Call<YoutubeSearchModel> call =
        searchService.getYoutubeSearchResult("snippet", query + " 먹방", YOUTUBE_API_KEY, 20);

        call.enqueue(new Callback<YoutubeSearchModel>() {
            @Override
            public void onResponse(Call<YoutubeSearchModel> call, Response<YoutubeSearchModel> response) {
                Log.d(TAG, "onResponse: " + response.code());

                if(response.code() == 200 && response.body().getYoutubeSearchResultsList() != null) {
                    for (int i = 0; i < response.body().getYoutubeSearchResultsList().size(); i++) {
                        youtubeDataArrayList.add(new YoutubeData(
                                response.body().getYoutubeSearchResultsList().get(i).getYoutubeSearchSnippets().getTitle(),
                                response.body().getYoutubeSearchResultsList().get(i).getVideoId().getId(),
                                response.body().getYoutubeSearchResultsList().get(i).getYoutubeSearchSnippets().getThumbnails().getMedium().getUrl()
                        ));
                    }
                }

                arrayListMutableLiveData.setValue(youtubeDataArrayList);
            }

            @Override
            public void onFailure(Call<YoutubeSearchModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public MutableLiveData<ArrayList<YoutubeData>> getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }
}
