package com.forif.watnyam.data.daumvideo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.forif.watnyam.Config.DAUM_APP_KEY;
import static com.forif.watnyam.Config.DAUM_REST_API_KEY;

public interface DaumService {

    //page 1 - 15 (default 1), size 1 - 30 (default 15)
//"Authorization: KakaoAK kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"

    @Headers("Authorization: KakaoAK " + DAUM_REST_API_KEY)
    @GET("search/vclip")
    Call<DaumVideoModel> getDaumVideo(@Query("query") String query,
                                      @Query("page") int page,
                                      @Query("size") int size);
}
