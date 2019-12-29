package com.forif.watnyam.data.naverimage;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.forif.watnyam.Config.NAVER_CLIENT_ID;
import static com.forif.watnyam.Config.NAVER_CLIENT_SECRET;


public interface NaverImageService {

    @Headers({"X-Naver-Client-id: " + NAVER_CLIENT_ID,
    "X-Naver-Client-Secret: " + NAVER_CLIENT_SECRET})
    @GET("search/image")
    Call<NaverImageItemsModel> getNaverImage(@Query("query") String query, @Query("display") int display, @Query("start") int start, @Query("sort") String sort, @Query("filter") String filter);

}
