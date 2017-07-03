package com.emadjaber.sporton;

import android.os.Parcel;
import android.os.Parcelable;


public class ActiveNews implements Parcelable {

    public String source;
    public News[] news;

    public ActiveNews(String source, News[] news) {
        this.source = source;
        this.news = news;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.source);
        dest.writeTypedArray(this.news, flags);
    }

    public ActiveNews() {
    }

    protected ActiveNews(Parcel in) {
        this.source = in.readString();
        this.news = in.createTypedArray(News.CREATOR);
    }

    public static final Parcelable.Creator<ActiveNews> CREATOR = new Parcelable.Creator<ActiveNews>() {
        @Override
        public ActiveNews createFromParcel(Parcel source) {
            return new ActiveNews(source);
        }

        @Override
        public ActiveNews[] newArray(int size) {
            return new ActiveNews[size];
        }
    };

    public int getPublisherImageResId() {
        switch (source){
            case "bbc-news":
                return R.drawable.bbc;
            default:
                return R.drawable.newspaper;
        }
    }
}
