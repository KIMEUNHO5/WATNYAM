package com.forif.watnyam.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GoogleData implements Parcelable {

    private String title;
    private String snippet;
    private String thumbnail;

    public GoogleData(String title, String snippet, String thumbnail) {
        this.title = title;
        this.snippet = snippet;
        this.thumbnail = thumbnail;
    }

    protected GoogleData(Parcel in) {
        title = in.readString();
        snippet = in.readString();
        thumbnail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(snippet);
        dest.writeString(thumbnail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GoogleData> CREATOR = new Creator<GoogleData>() {
        @Override
        public GoogleData createFromParcel(Parcel in) {
            return new GoogleData(in);
        }

        @Override
        public GoogleData[] newArray(int size) {
            return new GoogleData[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
