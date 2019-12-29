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
        searchService.getYoutubeSearchResult("snippet", "라면 먹방", YOUTUBE_API_KEY, 5);

        call.enqueue(new Callback<YoutubeSearchModel>() {
            @Override
            public void onResponse(Call<YoutubeSearchModel> call, Response<YoutubeSearchModel> response) {
                Log.d(TAG, "onResponse: " + response.code());

                for(int i = 0; i < response.body().getYoutubeSearchResultsList().size(); i++){
                    if(response.body().getYoutubeSearchResultsList().get(i).getYoutubeSearchSnippets() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getYoutubeSearchResultsList().get(i).getYoutubeSearchSnippets().getTitle());
                    }
                }
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
