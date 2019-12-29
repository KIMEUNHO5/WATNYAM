package com.forif.watnyam.data.youtube;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.forif.watnyam.model.YoutubeData;

import java.util.ArrayList;

public class YoutubeViewModel extends ViewModel{

    private YoutubeRepository youtubeRepository;

    public YoutubeViewModel(){
        youtubeRepository = YoutubeRepository.getInstance();
    }

    public void fetchYoutubeDataFromRepo(String query){
        youtubeRepository.fetchYoutubeData(query);
    }

    public MutableLiveData<ArrayList<YoutubeData>> getMutableLiveYoutubeData(){
        return youtubeRepository.getYoutubeMutableLiveData();
    }

}
