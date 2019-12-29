package com.forif.watnyam.data.naver;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NaverSearchResults implements Parcelable {

        @SerializedName("items")
        private List<NaverSearchItems> items;

        protected NaverSearchResults(Parcel in) {
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
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

        public List<NaverSearchItems> getItems(){
            return items;
        }

    }
