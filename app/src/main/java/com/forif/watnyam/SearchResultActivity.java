package com.forif.watnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.forif.watnyam.data.daumvideo.DaumVideoModel;
import com.forif.watnyam.data.daumvideo.DaumVideoViewModel;
import com.forif.watnyam.data.google.GoogleViewModel;
import com.forif.watnyam.data.naverblog.NaverViewModel;
import com.forif.watnyam.data.naverimage.NaverImageViewModel;
import com.forif.watnyam.data.youtube.YoutubeViewModel;
import com.forif.watnyam.database.MyRoomRepo;
import com.forif.watnyam.database.MyRoomViewModel;
import com.forif.watnyam.model.DaumVideoData;
import com.forif.watnyam.model.GoogleData;
import com.forif.watnyam.model.NaverData;
import com.forif.watnyam.model.NaverImageData;
import com.forif.watnyam.model.YoutubeData;
import com.forif.watnyam.recyclerviewadapters.DaumVideoRvAdapter;
import com.forif.watnyam.recyclerviewadapters.GoogleRvAdapter;
import com.forif.watnyam.recyclerviewadapters.NaverImageRvAdapter;
import com.forif.watnyam.recyclerviewadapters.NaverRvAdapter;
import com.forif.watnyam.recyclerviewadapters.YoutubeRvAdapter;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {

    RecyclerView rvNaverBlog, rvNaverImage, rvGoogle, rvYoutube, rvDaumVideo;
    RecyclerView.Adapter naverBlogAdapter, naverImageAdapter, googleAdapter, youtubeAdapter, daumVideoAdapter;
    MyRoomRepo myRoomRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        rvNaverBlog = findViewById(R.id.rv_naver_blog_result);
        rvNaverImage = findViewById(R.id.rv_naver_image_result);
        rvGoogle = findViewById(R.id.rv_google_result);
        rvYoutube = findViewById(R.id.rv_youtube_result);
        rvDaumVideo = findViewById(R.id.rv_daum_video_result);

        myRoomRepo = MyRoomRepo.getInstance(this);

        Intent intent = getIntent();
        String foodNameRoulette = intent.getStringExtra("roulette_result_key");


//        GoogleViewModel googleViewModel
//                = ViewModelProviders.of(this).get(GoogleViewModel.class);
//        googleViewModel.fetchGoogleSearchResults(foodNameRoulette);
//        googleViewModel.getMutableLiveGoogleData().observe(this, new Observer<ArrayList<GoogleData>>() {
//            @Override
//            public void onChanged(ArrayList<GoogleData> googleData) {
//                   googleAdapter = new GoogleRvAdapter(SearchResultActivity.this, googleData);
//                   rvGoogle.setHasFixedSize(true);
//                   LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchResultActivity.this);
//                   linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
//                   rvGoogle.setLayoutManager(linearLayoutManager);
//                   rvGoogle.setAdapter(googleAdapter);
//            }
//        });

        YoutubeViewModel youtubeViewModel = ViewModelProviders.of(this).get(YoutubeViewModel.class);
        youtubeViewModel.fetchYoutubeDataFromRepo(foodNameRoulette);
        youtubeViewModel.getMutableLiveYoutubeData().observe(this, new Observer<ArrayList<YoutubeData>>() {
            @Override
            public void onChanged(ArrayList<YoutubeData> youtubeData) {
                youtubeAdapter = new YoutubeRvAdapter(SearchResultActivity.this, youtubeData);
                rvYoutube.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchResultActivity.this);
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                rvYoutube.setLayoutManager(linearLayoutManager);
                rvYoutube.setAdapter(youtubeAdapter);
            }
        });

        NaverViewModel naverViewModel = ViewModelProviders.of(this).get(NaverViewModel.class);
        naverViewModel.fetchNaverSearchResults(foodNameRoulette);
        naverViewModel.getMutableLiveNaverData().observe(this, new Observer<ArrayList<NaverData>>() {
            @Override
            public void onChanged(ArrayList<NaverData> naverData) {
                naverBlogAdapter = new NaverRvAdapter(SearchResultActivity.this, naverData);
                rvNaverBlog.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchResultActivity.this);
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                rvNaverBlog.setLayoutManager(linearLayoutManager);
                rvNaverBlog.setAdapter(naverBlogAdapter);
            }
        });


        NaverImageViewModel naverImageViewModel = ViewModelProviders.of(this).get(NaverImageViewModel.class);
        naverImageViewModel.fetchNaverImageData(foodNameRoulette);
        naverImageViewModel.getNaverImageMutableLiveData().observe(this, new Observer<ArrayList<NaverImageData>>() {
            @Override
            public void onChanged(ArrayList<NaverImageData> naverImageData) {
                naverImageAdapter = new NaverImageRvAdapter(SearchResultActivity.this, naverImageData);
                rvNaverImage.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchResultActivity.this);
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                rvNaverImage.setLayoutManager(linearLayoutManager);
                rvNaverImage.setAdapter(naverImageAdapter);
            }
        });

        DaumVideoViewModel daumVideoViewModel = ViewModelProviders.of(this).get(DaumVideoViewModel.class);
        daumVideoViewModel.fetchDaumVideoResults(foodNameRoulette);
        daumVideoViewModel.getMutableLiveDaumVideoData().observe(this, new Observer<ArrayList<DaumVideoData>>() {
            @Override
            public void onChanged(ArrayList<DaumVideoData> daumVideoData) {
                daumVideoAdapter = new DaumVideoRvAdapter(SearchResultActivity.this, daumVideoData, myRoomRepo);
                rvDaumVideo.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchResultActivity.this);
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                rvDaumVideo.setLayoutManager(linearLayoutManager);
                rvDaumVideo.setAdapter(daumVideoAdapter);
            }
        });

    }
}
