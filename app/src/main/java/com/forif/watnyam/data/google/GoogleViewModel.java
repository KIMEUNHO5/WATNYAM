package com.forif.watnyam.data.google;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.forif.watnyam.model.GoogleData;

import java.util.ArrayList;

public class GoogleViewModel extends ViewModel {

    private GoogleRepository googleRepository;

    public GoogleViewModel(){
        googleRepository = GoogleRepository.getInstance();
    }

    public void fetchGoogleSearchResults(String query){
        googleRepository.fetchGoogleResultAsync(query);
    }

    public MutableLiveData<ArrayList<GoogleData>> getMutableLiveGoogleData(){
        return googleRepository.getMutableLiveGoogleData();
    }


}
