package com.forif.watnyam.data.daumvideo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.forif.watnyam.data.RetrofitInstanceBuilder;
import com.forif.watnyam.data.SearchService;
import com.forif.watnyam.model.DaumVideoData;
import com.forif.watnyam.model.GoogleData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DaumVideoClient {

    private static final String TAG = "DaumVideoClient";
    public static DaumVideoClient daumVideoClient;

    private MutableLiveData<ArrayList<DaumVideoData>> mutableLiveData = new MutableLiveData<>();
    private ArrayList<DaumVideoData> daumVideoDataArrayList = new ArrayList<>();

    public static DaumVideoClient getInstance() {
        if(daumVideoClient == null){
            daumVideoClient = new DaumVideoClient();
        }
        return daumVideoClient;
    }

    public void getResult(String query){
        DaumService daumService
        = RetrofitInstanceBuilder.getDaumService();

        Call<DaumVideoModel> call =
        daumService.getDaumVideo(query, 1, 20);

        call.enqueue(new Callback<DaumVideoModel>() {
            @Override
            public void onResponse(Call<DaumVideoModel> call, Response<DaumVideoModel> response) {
                Log.d(TAG, "onResponse: " + response.code());
                Log.d(TAG, "onResponse: " + response.message() + ", " + response.errorBody());
//                Log.d(TAG, "onResponse: " +
//                        response.body().getItems().get(0).getTitle() + "\n" +
//                        response.body().getItems().get(0).getThumbnail() + "\n" +
//                        response.body().getItems().get(0).getUrl() + "\n");
                if(response.code() == 200 && response.body().getItems() != null) {
                    List<DaumVideoResults> daumVideoResultsList = response.body().getItems();
                    for(int i = 0; i < daumVideoResultsList.size(); i++){
                        daumVideoDataArrayList.add(new DaumVideoData(
                           daumVideoResultsList.get(i).getTitle(),
                           daumVideoResultsList.get(i).getThumbnail(),
                           daumVideoResultsList.get(i).getUrl()
                        ));
                    }

                    mutableLiveData.setValue(daumVideoDataArrayList);
                }

            }

            @Override
            public void onFailure(Call<DaumVideoModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }


    public MutableLiveData<ArrayList<DaumVideoData>> getMutableLiveData() {
        return mutableLiveData;
    }
}
