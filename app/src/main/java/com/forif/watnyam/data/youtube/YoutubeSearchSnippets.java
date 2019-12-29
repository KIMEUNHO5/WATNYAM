package com.forif.watnyam.data.youtube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class YoutubeSearchSnippets implements Parcelable {

    @SerializedName("title")
    private String title;

    @SerializedName("thumbnails")
    private YoutubeThumbnailKey thumbnails;

    protected YoutubeSearchSnippets(Parcel in) {
        title = in.readString();
        thumbnails = in.readParcelable(YoutubeThumbnailKey.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeParcelable(thumbnails, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<YoutubeSearchSnippets> CREATOR = new Creator<YoutubeSearchSnippets>() {
        @Override
        public YoutubeSearchSnippets createFromParcel(Parcel in) {
            return new YoutubeSearchSnippets(in);
        }

        @Override
        public YoutubeSearchSnippets[] newArray(int size) {
            return new YoutubeSearchSnippets[size];
        }
    };

    public YoutubeThumbnailKey getThumbnails() {
        return thumbnails;
    }

    public String getTitle() {
        return title;
    }


}
