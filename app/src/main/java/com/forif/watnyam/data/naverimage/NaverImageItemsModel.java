package com.forif.watnyam.data.naverimage;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NaverImageItemsModel implements Parcelable {

    @SerializedName("items")
    private List<NaverImageResult> items;

    protected NaverImageItemsModel(Parcel in) {
    }

    public static final Creator<NaverImageItemsModel> CREATOR = new Creator<NaverImageItemsModel>() {
        @Override
        public NaverImageItemsModel createFromParcel(Parcel in) {
            return new NaverImageItemsModel(in);
        }

        @Override
        public NaverImageItemsModel[] newArray(int size) {
            return new NaverImageItemsModel[size];
        }
    };

    public List<NaverImageResult> getItems() {
        return items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
