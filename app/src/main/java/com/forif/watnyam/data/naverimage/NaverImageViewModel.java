package com.forif.watnyam.data.naverimage;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.forif.watnyam.model.NaverImageData;

import java.util.ArrayList;

public class NaverImageViewModel extends ViewModel {

    private NaverImageRepository naverImageRepository;

    public NaverImageViewModel(){
        naverImageRepository = NaverImageRepository.getInstance();
    }

    private MutableLiveData<ArrayList<NaverImageData>> naverImageMutableLiveData
            = new MutableLiveData<>();

    public void fetchNaverImageData(String query){
        naverImageRepository.fetchNaverImageResultAsync(query);
    }

    public MutableLiveData<ArrayList<NaverImageData>> getNaverImageMutableLiveData(){
        return naverImageRepository.getNaverImageData();
    }

}
