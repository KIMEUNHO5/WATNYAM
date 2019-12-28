package com.forif.watnyam.data.google;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GoogleSearchResults implements Parcelable {

    @SerializedName("title")
    private String title;

    @SerializedName("snippet")
    private String snippet;

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }

    protected GoogleSearchResults(Parcel in) {
        title = in.readString();
        snippet = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(snippet);
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
}
