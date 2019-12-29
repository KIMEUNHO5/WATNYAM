package com.forif.watnyam.data.naver;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NaverSearchItemsModel implements Parcelable{

    @SerializedName("items")
    private List<NaverSearchResults> NaverSearchList;

    protected NaverSearchItemsModel(Parcel in) {
        NaverSearchList = in.createTypedArrayList(NaverSearchResults.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(NaverSearchList);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public List<NaverSearchResults> getNaverSearchList() {
        return NaverSearchList;
    }


}
