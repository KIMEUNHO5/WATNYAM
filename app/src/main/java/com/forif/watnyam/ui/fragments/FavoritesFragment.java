package com.forif.watnyam.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forif.watnyam.R;
import com.forif.watnyam.SearchResultActivity;
import com.forif.watnyam.database.LikedPost;
import com.forif.watnyam.database.MyRoomViewModel;
import com.forif.watnyam.recyclerviewadapters.LikedPostRvAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {

    private RecyclerView recyclerView;
    private LikedPostRvAdapter likedPostRvAdapter;
    private MyRoomViewModel myRoomViewModel;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    public static FavoritesFragment newInstance(String param1, String param2) {
        FavoritesFragment fragment = new FavoritesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myRoomViewModel = ViewModelProviders.of(this).get(MyRoomViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        recyclerView = view.findViewById(R.id.rv_liked_posts);

        myRoomViewModel.getLikedPostsLiveDataFromRepo().observe(this, new Observer<List<LikedPost>>() {
            @Override
            public void onChanged(List<LikedPost> likedPosts) {
                likedPostRvAdapter = new LikedPostRvAdapter(getContext(), (ArrayList<LikedPost>) likedPosts);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(likedPostRvAdapter);
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
