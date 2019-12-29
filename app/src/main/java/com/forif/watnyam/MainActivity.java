package com.forif.watnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.forif.watnyam.data.google.GoogleSearchClient;
import com.forif.watnyam.data.google.GoogleViewModel;
import com.forif.watnyam.data.naver.NaverSearchClient;
import com.forif.watnyam.data.naverimage.NaverImageRepository;
import com.forif.watnyam.data.naverimage.NaverImageViewModel;
import com.forif.watnyam.data.youtube.YoutubeSearchClient;
import com.forif.watnyam.data.youtube.YoutubeViewModel;
import com.forif.watnyam.ui.fragments.MyFragPagerAdapter;
import com.forif.watnyam.ui.fragments.RouletteFragment;
import com.forif.watnyam.ui.fragments.WorldCupFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
        implements RouletteFragment.OnFragmentInteractionListener
                , WorldCupFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragPagerAdapter myFragPagerAdapter = new MyFragPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(myFragPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        GoogleViewModel googleViewModel
                = ViewModelProviders.of(this).get(GoogleViewModel.class);
        googleViewModel.fetchGoogleSearchResults("mashed potato");

        YoutubeViewModel youtubeViewModel = ViewModelProviders.of(this).get(YoutubeViewModel.class);
        youtubeViewModel.fetchYoutubeDataFromRepo("치킨");

//        NaverSearchClient naverSearchClient = NaverSearchClient.getInstance();
//        naverSearchClient.executeNaver();

        NaverImageViewModel naverImageViewModel = ViewModelProviders.of(this).get(NaverImageViewModel.class);
        naverImageViewModel.fetchNaverImageData("라면");


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
