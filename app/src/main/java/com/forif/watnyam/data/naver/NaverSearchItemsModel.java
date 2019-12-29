package com.forif.watnyam.data.naver;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NaverSearchItemsModel implements Parcelable{

    @SerializedName("items")
    private List<NaverSearchItemsModel> NaverSearchList;

    public List<NaverSearchItemsModel> getNaverSearchList() {
        return NaverSearchList;
    }

    protected NaverSearchItemsModel(Parcel in) {
        NaverSearchList = in.createTypedArrayList(NaverSearchItemsModel.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static final Creator<NaverSearchItemsModel> CREATOR = new Creator<NaverSearchItemsModel>() {
        @Override
        public NaverSearchItemsModel createFromParcel(Parcel in) {
            return new NaverSearchItemsModel(in);
        }

        @Override
        public NaverSearchItemsModel[] newArray(int size) {
            return new NaverSearchItemsModel[size];
        }
    };
}
