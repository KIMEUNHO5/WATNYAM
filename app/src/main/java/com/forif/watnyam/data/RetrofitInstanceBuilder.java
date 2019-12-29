package com.forif.watnyam.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceBuilder {

    public static final String GOOGLE_SEARCH_BASE_URL = "https://www.googleapis.com/";

    public static final String YOUTUBE_SEARCH_BASE_URL = "https://www.googleapis.com/";

    public static final String NAVER_SEARCH_BASE_URL = "https://www.googleapis.com/";



    private static Retrofit retrofitGoogle
            = new Retrofit.Builder().baseUrl(GOOGLE_SEARCH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final SearchService GOOGLE_SEARCH_SERVICE
            = retrofitGoogle.create(SearchService.class);

    public static SearchService getGoogleSearchService() {
        return GOOGLE_SEARCH_SERVICE;
    }

    //boilerplate
    private static Retrofit retrofitYoutube
            = new Retrofit.Builder().baseUrl(YOUTUBE_SEARCH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build();

    private static final SearchService YOUTUBE_SEARCH_SERVICE
            = retrofitYoutube.create(SearchService.class);

    public static SearchService getYoutubeSearchService(){return YOUTUBE_SEARCH_SERVICE; }


    private static Retrofit retrofitNaver
            = new Retrofit.Builder().baseUrl(NAVER_SEARCH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final SearchService NAVER_SEARCH_SERVICE
            = retrofitNaver.create(SearchService.class);

    public static SearchService getNaverSearchService() {
        return NAVER_SEARCH_SERVICE;
    }

}
