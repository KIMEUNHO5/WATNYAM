package com.forif.watnyam.data.google;

import androidx.lifecycle.ViewModel;

public class GoogleViewModel extends ViewModel {

    private GoogleRepository googleRepository;

    public GoogleViewModel(){
        googleRepository = GoogleRepository.getInstance();
    }

    public void fetchGoogleSearchResults(){
        googleRepository.fetchGoogleResultAsync();
    }

    //getters

}
