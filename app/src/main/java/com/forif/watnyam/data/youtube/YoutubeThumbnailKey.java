package com.forif.watnyam.data.youtube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class YoutubeThumbnailKey implements Parcelable {

    @SerializedName("medium")
    private YTImage medium;

    protected YoutubeThumbnailKey(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<YoutubeThumbnailKey> CREATOR = new Creator<YoutubeThumbnailKey>() {
        @Override
        public YoutubeThumbnailKey createFromParcel(Parcel in) {
            return new YoutubeThumbnailKey(in);
        }

        @Override
        public YoutubeThumbnailKey[] newArray(int size) {
            return new YoutubeThumbnailKey[size];
        }
    };

    public YTImage getMedium() {
        return medium;
    }

}
