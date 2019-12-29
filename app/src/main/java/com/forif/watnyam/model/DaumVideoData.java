package com.forif.watnyam.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DaumVideoData implements Parcelable {

    private String title;
    private String thumbnail;
    private String url;

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public DaumVideoData(String title, String thumbnail, String url) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.url = url;
    }

    protected DaumVideoData(Parcel in) {
        title = in.readString();
        thumbnail = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(thumbnail);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DaumVideoData> CREATOR = new Creator<DaumVideoData>() {
        @Override
        public DaumVideoData createFromParcel(Parcel in) {
            return new DaumVideoData(in);
        }

        @Override
        public DaumVideoData[] newArray(int size) {
            return new DaumVideoData[size];
        }
    };
}
