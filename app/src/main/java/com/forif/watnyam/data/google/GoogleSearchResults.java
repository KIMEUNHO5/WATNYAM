package com.forif.watnyam.data.google;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoogleSearchResults implements Parcelable {

    @SerializedName("title")
    private String title;

    @SerializedName("snippet")
    private String snippet;

    @SerializedName("pagemap")
    private GoogleThumbnails thumbnails;


    protected GoogleSearchResults(Parcel in) {
        title = in.readString();
        snippet = in.readString();
        thumbnails = in.readParcelable(GoogleThumbnails.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(snippet);
        dest.writeParcelable(thumbnails, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GoogleSearchResults> CREATOR = new Creator<GoogleSearchResults>() {
        @Override
        public GoogleSearchResults createFromParcel(Parcel in) {
            return new GoogleSearchResults(in);
        }

        @Override
        public GoogleSearchResults[] newArray(int size) {
            return new GoogleSearchResults[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }

    public GoogleThumbnails getThumbnails() {
        return thumbnails;
    }
}
