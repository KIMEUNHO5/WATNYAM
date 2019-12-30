package com.forif.watnyam;

import androidx.annotation.FontRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forif.watnyam.ui.fragments.MyFragPagerAdapter;
import com.forif.watnyam.ui.fragments.RouletteFragment;
import com.forif.watnyam.ui.fragments.WorldCupFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
        implements RouletteFragment.OnFragmentInteractionListener
                , WorldCupFragment.OnFragmentInteractionListener{

    private static final String TAG = "MainActivity";
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragPagerAdapter myFragPagerAdapter = new MyFragPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(myFragPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        typeface = Typeface.create("bungee.ttf", Typeface.NORMAL);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
