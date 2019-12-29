package com.forif.watnyam.data.naverimage;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NaverImageResult implements Parcelable {

    @SerializedName("title")
    private String title;
    @SerializedName("link")
    private String link;
    @SerializedName("thumbnail")
    private String thumbnail;

    protected NaverImageResult(Parcel in) {
        title = in.readString();
        link = in.readString();
        thumbnail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(thumbnail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NaverImageResult> CREATOR = new Creator<NaverImageResult>() {
        @Override
        public NaverImageResult createFromParcel(Parcel in) {
            return new NaverImageResult(in);
        }

        @Override
        public NaverImageResult[] newArray(int size) {
            return new NaverImageResult[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
