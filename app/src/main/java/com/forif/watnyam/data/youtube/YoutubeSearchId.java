package com.forif.watnyam.data.youtube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class YoutubeSearchId implements Parcelable {

    @SerializedName("videoId")
    private String id;

    protected YoutubeSearchId(Parcel in) {
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<YoutubeSearchId> CREATOR = new Creator<YoutubeSearchId>() {
        @Override
        public YoutubeSearchId createFromParcel(Parcel in) {
            return new YoutubeSearchId(in);
        }

        @Override
        public YoutubeSearchId[] newArray(int size) {
            return new YoutubeSearchId[size];
        }
    };

    public String getId() {
        return id;
    }


}
