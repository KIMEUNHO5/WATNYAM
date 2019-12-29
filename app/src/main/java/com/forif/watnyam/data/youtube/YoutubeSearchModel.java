package com.forif.watnyam.data.youtube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YoutubeSearchModel implements Parcelable{

    @SerializedName("items")
    private List<YoutubeSearchResults> youtubeSearchResultsList;

    protected YoutubeSearchModel(Parcel in) {
        youtubeSearchResultsList = in.createTypedArrayList(YoutubeSearchResults.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(youtubeSearchResultsList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<YoutubeSearchModel> CREATOR = new Creator<YoutubeSearchModel>() {
        @Override
        public YoutubeSearchModel createFromParcel(Parcel in) {
            return new YoutubeSearchModel(in);
        }

        @Override
        public YoutubeSearchModel[] newArray(int size) {
            return new YoutubeSearchModel[size];
        }
    };

    public List<YoutubeSearchResults> getYoutubeSearchResultsList() {
        return youtubeSearchResultsList;
    }


}
