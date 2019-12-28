package com.forif.watnyam.data.youtube;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class YoutubeSearchResults implements Parcelable{

    @SerializedName("videoId")
    private String videoId;

    @SerializedName("thumbnails")
    private YoutubeThumbnail youtubeThumbnail;



    protected YoutubeSearchResults(Parcel in) {
        videoId = in.readString();
        youtubeThumbnail = in.readParcelable(YoutubeThumbnail.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(videoId);
        dest.writeParcelable(youtubeThumbnail, flags);
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

    public String getVideoId() {
            return videoId;
    }

    public YoutubeThumbnail getYoutubeThumbnail() {
        return youtubeThumbnail;
    }

        //    {
//  "kind": "youtube#searchResult",
//  "etag": etag,
//  "id": {
//    "kind": string,
//    "videoId": string,
//    "channelId": string,
//    "playlistId": string
//  },
//  "snippet": {
//    "publishedAt": datetime,
//    "channelId": string,
//    "title": string,
//    "description": string,
//    "thumbnails": {
//      (key): {
//        "url": string,
//        "width": unsigned integer,
//        "height": unsigned integer
//      }
//    },
//    "channelTitle": string
//  }
//}

}

