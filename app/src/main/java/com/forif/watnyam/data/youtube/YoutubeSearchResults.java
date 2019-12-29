package com.forif.watnyam.data.youtube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class YoutubeSearchResults implements Parcelable{

    @SerializedName("id")
    private YoutubeSearchId videoId;

    @SerializedName("snippet")
    private YoutubeSearchSnippets youtubeSearchSnippets;

    public YoutubeSearchId getVideoId() {
        return videoId;
    }

    public YoutubeSearchSnippets getYoutubeSearchSnippets() {
        return youtubeSearchSnippets;
    }

    protected YoutubeSearchResults(Parcel in) {
        videoId = in.readParcelable(YoutubeSearchId.class.getClassLoader());
        youtubeSearchSnippets = in.readParcelable(YoutubeSearchSnippets.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(videoId, flags);
        dest.writeParcelable(youtubeSearchSnippets, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<YoutubeSearchResults> CREATOR = new Creator<YoutubeSearchResults>() {
        @Override
        public YoutubeSearchResults createFromParcel(Parcel in) {
            return new YoutubeSearchResults(in);
        }

        @Override
        public YoutubeSearchResults[] newArray(int size) {
            return new YoutubeSearchResults[size];
        }
    };
}

