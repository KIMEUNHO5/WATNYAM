package com.forif.watnyam.data.google;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoogleThumbnails implements Parcelable {

    @SerializedName("cse_image")
    private List<GoogleImage> googleImageList;

    public List<GoogleImage> getGoogleImageList() {
        return googleImageList;
    }

    protected GoogleThumbnails(Parcel in) {
        googleImageList = in.createTypedArrayList(GoogleImage.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(googleImageList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GoogleThumbnails> CREATOR = new Creator<GoogleThumbnails>() {
        @Override
        public GoogleThumbnails createFromParcel(Parcel in) {
            return new GoogleThumbnails(in);
        }

        @Override
        public GoogleThumbnails[] newArray(int size) {
            return new GoogleThumbnails[size];
        }
    };
}
