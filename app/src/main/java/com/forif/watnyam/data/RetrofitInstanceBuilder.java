package com.forif.watnyam.data;

import com.forif.watnyam.data.google.GoogleSearchService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceBuilder {

    public static final String GOOGLE_SEARCH_BASE_URL = "https://www.googleapis.com/";

    public static final String YOUTUBE_SEARCH_BASE_URL = "https://www.googleapis.com/";


    private static Retrofit retrofit
            = new Retrofit.Builder().baseUrl(GOOGLE_SEARCH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final GoogleSearchService GOOGLE_SEARCH_SERVICE
            = retrofit.create(GoogleSearchService.class);

    public static GoogleSearchService getGoogleSearchService() {
        return GOOGLE_SEARCH_SERVICE;
    }

}
