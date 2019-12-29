package com.forif.watnyam.data.google;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GoogleImage implements Parcelable {

    @SerializedName("src")
    private String src;

    protected GoogleImage(Parcel in) {
        src = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(src);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GoogleImage> CREATOR = new Creator<GoogleImage>() {
        @Override
        public GoogleImage createFromParcel(Parcel in) {
            return new GoogleImage(in);
        }

        @Override
        public GoogleImage[] newArray(int size) {
            return new GoogleImage[size];
        }
    };

    public String getSrc() {
        return src;
    }


}
