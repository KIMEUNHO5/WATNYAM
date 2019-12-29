package com.forif.watnyam.data.naver;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NaverSearchModel implements Parcelable{

    @SerializedName("items")
    private List<NaverSearchModel> NaverSearchList;

    public List<NaverSearchModel> getNaverSearchList() {
        return NaverSearchList;
    }

    protected NaverSearchModel(Parcel in) {
        NaverSearchList = in.createTypedArrayList(NaverSearchModel.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static final Creator<NaverSearchModel> CREATOR = new Creator<NaverSearchModel>() {
        @Override
        public NaverSearchModel createFromParcel(Parcel in) {
            return new NaverSearchModel(in);
        }

        @Override
        public NaverSearchModel[] newArray(int size) {
            return new NaverSearchModel[size];
        }
    };
}
