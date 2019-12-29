package com.forif.watnyam.data.naver;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NaverSearchItems implements Parcelable {


    @SerializedName("title")
    private String title;
    @SerializedName("link")
    private String link;
    @SerializedName("description")
    private String description;

    protected NaverSearchItems(Parcel in) {
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

    public static final Creator<NaverSearchItems> CREATOR = new Creator<NaverSearchItems>() {
        @Override
        public NaverSearchItems createFromParcel(Parcel in) {
            return new NaverSearchItems(in);
        }

        @Override
        public NaverSearchItems[] newArray(int size) {
            return new NaverSearchItems[size];
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
