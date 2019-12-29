package com.forif.watnyam.data.naver;

import androidx.lifecycle.ViewModel;

public class NaverViewModel extends ViewModel {

    private NaverSearchRepository naverSearchRepository;

    public NaverViewModel(){
        naverSearchRepository = NaverSearchRepository.getInstance();
    }

    public void fetchNaverSearchResults(){ naverSearchRepository.fetchNaverResultAsync();
    }
}
