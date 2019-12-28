package com.gahee.watnyam.ui.fragments;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragPagerAdapter extends FragmentPagerAdapter {

    public MyFragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new RouletteFragment();
                break;
            case 1:
                fragment = new WorldCupFragment();
                break;
            case 2:
                fragment = new FavoritesFragment();
                break;

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "ROULETTE";
            case 1:
                return "WORLD CUP";
            case 2:
                return "FAVORITES";
        }
        return null;
    }
}
