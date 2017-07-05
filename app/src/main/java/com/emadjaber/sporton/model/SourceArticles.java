package com.emadjaber.sporton.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.emadjaber.sporton.R;


public class SourceArticles implements Parcelable {

    public String source;
    public Articles[] articles;

    public SourceArticles(String source, Articles[] articles) {
        this.source = source;
        this.articles = articles;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.source);
        dest.writeTypedArray(this.articles, flags);
    }

    public SourceArticles() {
    }

    protected SourceArticles(Parcel in) {
        this.source = in.readString();
        this.articles = in.createTypedArray(Articles.CREATOR);
    }

    public static final Parcelable.Creator<SourceArticles> CREATOR = new Parcelable.Creator<SourceArticles>() {
        @Override
        public SourceArticles createFromParcel(Parcel source) {
            return new SourceArticles(source);
        }

        @Override
        public SourceArticles[] newArray(int size) {
            return new SourceArticles[size];
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
