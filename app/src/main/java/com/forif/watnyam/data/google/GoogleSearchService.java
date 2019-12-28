package com.forif.watnyam.data.google;


import com.forif.watnyam.data.youtube.YoutubeSearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleSearchService {

    //+ searchStringNoSpaces + "&key=" + key + "&cx=" + cx + "&alt=json"

    @GET("customsearch/v1?")
    Call<GoogleSearchModel> getGoogleSearchResult(@Query("q") String query, @Query("key") String key, @Query("cx") String cx, @Query("alt") String json);

    @GET("youtube/v3/search?")
    Call<YoutubeSearchModel> getYoutubeSearchResult(@Query("q") String query, @Query("key") String key);

}
