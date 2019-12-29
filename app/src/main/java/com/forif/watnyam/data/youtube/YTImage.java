package com.forif.watnyam.data.youtube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class YTImage implements Parcelable {

        @SerializedName("url")
        private String url;

        protected YTImage(Parcel in) {
            url = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(url);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<YTImage> CREATOR = new Creator<YTImage>() {
            @Override
            public YTImage createFromParcel(Parcel in) {
                return new YTImage(in);
            }

            @Override
            public YTImage[] newArray(int size) {
                return new YTImage[size];
            }
        };

        public String getUrl() {
            return url;
        }


}
