package com.forif.watnyam.data.naver;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NaverSearchResults implements Parcelable {


    @SerializedName("title")
    private String title;
    @SerializedName("link")
    private String link;
    @SerializedName("description")
    private String description;

    protected NaverSearchResults(Parcel in) {
        title = in.readString();
        link = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NaverSearchResults> CREATOR = new Creator<NaverSearchResults>() {
        @Override
        public NaverSearchResults createFromParcel(Parcel in) {
            return new NaverSearchResults(in);
        }

        @Override
        public NaverSearchResults[] newArray(int size) {
            return new NaverSearchResults[size];
        }
    };

    public String getTitle(){
        return title;
    }

    public String getLink(){
        return link;
    }

    public String getDescription(){
        return description;
    }
}
