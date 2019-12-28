package com.forif.watnyam.data.google;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoogleSearchModel implements Parcelable {

    @SerializedName("items")
    private List<GoogleSearchResults> items;

    public List<GoogleSearchResults> getItems() {
        return items;
    }

    protected GoogleSearchModel(Parcel in) {
        items = in.createTypedArrayList(GoogleSearchResults.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(items);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GoogleSearchModel> CREATOR = new Creator<GoogleSearchModel>() {
        @Override
        public GoogleSearchModel createFromParcel(Parcel in) {
            return new GoogleSearchModel(in);
        }

        @Override
        public GoogleSearchModel[] newArray(int size) {
            return new GoogleSearchModel[size];
        }
    };
}
