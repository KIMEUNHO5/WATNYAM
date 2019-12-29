package com.forif.watnyam.data;


import com.forif.watnyam.data.google.GoogleSearchModel;
import com.forif.watnyam.data.naverblog.NaverSearchItemsModel;
import com.forif.watnyam.data.youtube.YoutubeSearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.forif.watnyam.Config.NAVER_BLOG_CLIENT_ID;
import static com.forif.watnyam.Config.NAVER_BLOG_CLIENT_SECRET;

public interface SearchService {

    //+ searchStringNoSpaces + "&key=" + key + "&cx=" + cx + "&alt=json"

    @GET("customsearch/v1?")
    Call<GoogleSearchModel> getGoogleSearchResult(@Query("q") String query, @Query("key") String key, @Query("cx") String cx, @Query("alt") String json);

    // "https://www.googleapis.com/youtube/v3/search?"
    //                        + "part=snippet&q=" + et.getText().toString()
    //                        + "&key="+ serverKey+"&maxResults=50");  //EditText에 입력된 값으로 겁색을 합니다.
    //                            // part(snippet),  q(검색값) , key(서버키)

    @GET("youtube/v3/search?")
    Call<YoutubeSearchModel> getYoutubeSearchResult(@Query("part") String snippet, @Query("q") String query, @Query("key") String key, @Query("maxResults") int maxResults);

    @Headers({"X-Naver-Client-id: " + NAVER_BLOG_CLIENT_ID,
            "X-Naver-Client-Secret: " + NAVER_BLOG_CLIENT_SECRET})
    @GET("search/blog.json")
    Call<NaverSearchItemsModel> getNaverSearchResult(@Query("query") String query, @Query("display") int display, @Query("start") int start, @Query("sort") String sort);


}
