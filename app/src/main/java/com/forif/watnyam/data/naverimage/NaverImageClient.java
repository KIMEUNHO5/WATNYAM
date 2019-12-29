package com.forif.watnyam.data.naverimage;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.model.NaverImageData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverImageClient {

    private static final String TAG = "NaverImageClient";
    private static NaverImageClient naverImageClient;

    private ArrayList<NaverImageData> naverImageDataArrayList = new ArrayList<>();
    private MutableLiveData<ArrayList<NaverImageData>> mutableLiveData = new MutableLiveData<>();

    public static NaverImageClient getInstance() {
        if(naverImageClient == null){
            naverImageClient = new NaverImageClient();
        }
        return naverImageClient;
    }

    public void getNaverImageResult(String query){
        NaverImageService naverImageService =
                RetrofitInstanceBuilder.getNaverImageService();

        Call<NaverImageItemsModel> naverImageItemsModelCall
                = naverImageService.getNaverImage(
                        query + "먹방",20, 1, "sim", "medium"
        );

        naverImageItemsModelCall.enqueue(new Callback<NaverImageItemsModel>() {
            @Override
            public void onResponse(Call<NaverImageItemsModel> call, Response<NaverImageItemsModel> response) {
                Log.d(TAG, "onResponse: " + response.code());
//                for(int i = 0; i < response.body().getItems().size(); i++) {
//                    Log.d(TAG, "onResponse: " + response.body().getItems().get(i).getThumbnail());
//                }

                if(response.code() == 200 && response.body().getItems() != null) {

                    for (int i = 0; i < response.body().getItems().size(); i++) {
                        naverImageDataArrayList.add(new NaverImageData(
                                response.body().getItems().get(i).getTitle(),
                                response.body().getItems().get(i).getLink(),
                                response.body().getItems().get(i).getThumbnail()
                        ));
                    }

                    mutableLiveData.setValue(naverImageDataArrayList);
                }
            }

            @Override
            public void onFailure(Call<NaverImageItemsModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public MutableLiveData<ArrayList<NaverImageData>> getMutableLiveData() {
        return mutableLiveData;
    }
}
