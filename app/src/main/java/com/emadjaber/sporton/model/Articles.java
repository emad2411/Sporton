package com.emadjaber.sporton.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Articles implements Parcelable {

    private String mAuthorName;
    private String mTitle;
    private String mNewsDescription;
    private String mPublishDate;
    private String mURL;
    private String mImageURL;

    public Articles(String authorName, String title, String newsDescription, String publishDate, String URL, String imageURL) {
        mAuthorName = authorName;
        mTitle = title;
        mNewsDescription = newsDescription;
        mPublishDate = publishDate;
        mURL = URL;
        mImageURL = imageURL;
    }

    public String getAuthorName() {
        return mAuthorName;
    }

    public void setAuthorName(String authorName) {
        mAuthorName = authorName;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getNewsDescription() {
        return mNewsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        mNewsDescription = newsDescription;
    }

    public String getPublishDate() {
        return mPublishDate;
    }

    public void setPublishDate(String publishDate) {
        mPublishDate = publishDate;
    }

    public String getURL() {
        return mURL;
    }

    public void setURL(String URL) {
        mURL = URL;
    }

    public String getImageURL() {
        return mImageURL;
    }

    public void setImageURL(String imageURL) {
        mImageURL = imageURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mAuthorName);
        dest.writeString(this.mTitle);
        dest.writeString(this.mNewsDescription);
        dest.writeString(this.mPublishDate);
        dest.writeString(this.mURL);
        dest.writeString(this.mImageURL);
    }



    protected Articles(Parcel in) {
        this.mAuthorName = in.readString();
        this.mTitle = in.readString();
        this.mNewsDescription = in.readString();
        this.mPublishDate = in.readString();
        this.mURL = in.readString();
        this.mImageURL = in.readString();
    }

    public static final Parcelable.Creator<Articles> CREATOR = new Parcelable.Creator<Articles>() {
        @Override
        public Articles createFromParcel(Parcel source) {
            return new Articles(source);
        }

        @Override
        public Articles[] newArray(int size) {
            return new Articles[size];
        }
    };

}
