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
import com.forif.watnyam.data.naver.NaverViewModel;
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


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
