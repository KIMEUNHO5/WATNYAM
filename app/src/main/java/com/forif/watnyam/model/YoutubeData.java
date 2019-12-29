package com.forif.watnyam.model;

import android.os.Parcel;
import android.os.Parcelable;

public class YoutubeData implements Parcelable {

    private String title;
    private String id;
    private String thumbnail;

    public YoutubeData(String title, String id, String thumbnail) {
        this.title = title;
        this.id = id;
        this.thumbnail = thumbnail;
    }

    protected YoutubeData(Parcel in) {
        title = in.readString();
        id = in.readString();
        thumbnail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(id);
        dest.writeString(thumbnail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<YoutubeData> CREATOR = new Creator<YoutubeData>() {
        @Override
        public YoutubeData createFromParcel(Parcel in) {
            return new YoutubeData(in);
        }

        @Override
        public YoutubeData[] newArray(int size) {
            return new YoutubeData[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
