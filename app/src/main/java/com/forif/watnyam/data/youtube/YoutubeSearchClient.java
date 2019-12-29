package com.forif.watnyam.data.youtube;

import android.os.AsyncTask;
import android.util.Log;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.data.SearchService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.forif.watnyam.Config.YOUTUBE_API_KEY;

public class YoutubeSearchClient {
    private static final String TAG = "YoutubeSearchClient";
    private static YoutubeSearchClient youtubeSearchClient;

    public static YoutubeSearchClient getInstance() {
        if(youtubeSearchClient == null){
            youtubeSearchClient = new YoutubeSearchClient();
        }
        return youtubeSearchClient;
    }

    public void getYoutubeResult(){
        SearchService searchService = RetrofitInstanceBuilder.getYoutubeSearchService();
        Call<YoutubeSearchModel> call =
        searchService.getYoutubeSearchResult("snippet", "jazz music", YOUTUBE_API_KEY, 50);

        call.enqueue(new Callback<YoutubeSearchModel>() {
            @Override
            public void onResponse(Call<YoutubeSearchModel> call, Response<YoutubeSearchModel> response) {
                Log.d(TAG, "onResponse: " + response.code());
                Log.d(TAG, "onResponse: " + response.body().getYoutubeSearchResultsList().get(0).getVideoId());
            }

            @Override
            public void onFailure(Call<YoutubeSearchModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    class YoutubeAsync extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            getYoutubeResult();
            return null;
        }
    }

    public void executeYoutube(){
        new YoutubeAsync().execute();
    }

}
