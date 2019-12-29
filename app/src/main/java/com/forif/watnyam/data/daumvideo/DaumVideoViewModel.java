package com.forif.watnyam.data.daumvideo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.forif.watnyam.model.DaumVideoData;
import com.forif.watnyam.model.GoogleData;

import java.util.ArrayList;

public class DaumVideoViewModel extends ViewModel {

    private DaumRepository googleRepository;

    public DaumVideoViewModel(){
        googleRepository = DaumRepository.getInstance();
    }

    public void fetchDaumVideoResults(String query){
        googleRepository.fetchDaumResultAsync(query);
    }

    public MutableLiveData<ArrayList<DaumVideoData>> getMutableLiveDaumVideoData(){
        return googleRepository.getMutableLiveDaumVideoData();
    }


}
