package com.forif.watnyam.data.naverimage;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NaverImageModel implements Parcelable {

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("pubDate")
    private String pubDate;

    protected NaverImageModel(Parcel in) {
        title = in.readString();
        description = in.readString();
        pubDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(pubDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NaverImageModel> CREATOR = new Creator<NaverImageModel>() {
        @Override
        public NaverImageModel createFromParcel(Parcel in) {
            return new NaverImageModel(in);
        }

        @Override
        public NaverImageModel[] newArray(int size) {
            return new NaverImageModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }
}
