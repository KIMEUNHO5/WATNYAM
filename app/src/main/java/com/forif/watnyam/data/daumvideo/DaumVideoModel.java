package com.forif.watnyam.data.daumvideo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DaumVideoModel implements Parcelable {

    @SerializedName("documents")
    private List<DaumVideoResults> items;

    protected DaumVideoModel(Parcel in) {
        items = in.createTypedArrayList(DaumVideoResults.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(items);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DaumVideoModel> CREATOR = new Creator<DaumVideoModel>() {
        @Override
        public DaumVideoModel createFromParcel(Parcel in) {
            return new DaumVideoModel(in);
        }

        @Override
        public DaumVideoModel[] newArray(int size) {
            return new DaumVideoModel[size];
        }
    };

    public List<DaumVideoResults> getItems() {
        return items;
    }


}
