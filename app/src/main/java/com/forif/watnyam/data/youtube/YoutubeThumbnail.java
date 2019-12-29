package com.forif.watnyam.data.youtube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class YoutubeThumbnail implements Parcelable {

    @SerializedName("url")
    private String url;

    protected YoutubeThumbnail(Parcel in) {
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<YoutubeThumbnail> CREATOR = new Creator<YoutubeThumbnail>() {
        @Override
        public YoutubeThumbnail createFromParcel(Parcel in) {
            return new YoutubeThumbnail(in);
        }

        @Override
        public YoutubeThumbnail[] newArray(int size) {
            return new YoutubeThumbnail[size];
        }
    };

    public String getUrl() {
        return url;
    }
}
