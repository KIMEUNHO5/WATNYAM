package com.forif.watnyam.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NaverData implements Parcelable {

    private String title;
    private String link;
    private String description;

    public NaverData(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    protected NaverData(Parcel in) {
        title = in.readString();
        link = in.readString();
        description = in.readString();
    }

    public static final Creator<NaverData> CREATOR = new Creator<NaverData>() {
        @Override
        public NaverData createFromParcel(Parcel in) {
            return new NaverData(in);
        }

        @Override
        public NaverData[] newArray(int size) {
            return new NaverData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(description);
    }
}