package com.forif.watnyam.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NaverImageData implements Parcelable {

    private String title;
    private String link;
    private String thumbnail;

    public NaverImageData(String title, String link, String thumbnail) {
        this.title = title;
        this.link = link;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    protected NaverImageData(Parcel in) {
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

    public static final Creator<NaverImageData> CREATOR = new Creator<NaverImageData>() {
        @Override
        public NaverImageData createFromParcel(Parcel in) {
            return new NaverImageData(in);
        }

        @Override
        public NaverImageData[] newArray(int size) {
            return new NaverImageData[size];
        }
    };
}
