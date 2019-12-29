package com.forif.watnyam.data.daumvideo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DaumVideoResults implements Parcelable {

    @SerializedName("title")
    private String title;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("url")
    private String url;

    protected DaumVideoResults(Parcel in) {
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

    public static final Creator<DaumVideoResults> CREATOR = new Creator<DaumVideoResults>() {
        @Override
        public DaumVideoResults createFromParcel(Parcel in) {
            return new DaumVideoResults(in);
        }

        @Override
        public DaumVideoResults[] newArray(int size) {
            return new DaumVideoResults[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }


}
