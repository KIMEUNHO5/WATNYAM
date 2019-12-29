package com.forif.watnyam.data.naverimage;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NaverImageViewModel extends ViewModel {

    MutableLiveData<NaverImageItemsModel> newsItemsLive = new MutableLiveData<>();
    private Repo repo;

    public NaverImageViewModel(){
        repo = Repo.getInstance();
    }

    public MutableLiveData<NaverImageItemsModel> getNewsItemsLive() {
        newsItemsLive = repo.getNewsItemsModelMutableLiveData();
        return newsItemsLive;
    }

    public void fetchNews(String q, int d, int s, String st){
        repo.executeNewsAsync(q, d, s, st);
    }

}
