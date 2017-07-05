package com.emadjaber.sporton.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Articles implements Parcelable {

    private String author;
    private String title;
    private String description;
    private String publishedAt;
    private String url;
    private String urlToImage;

    public Articles(String authorName, String title, String newsDescription, String publishDate, String URL, String image) {
        author = authorName;
        this.title = title;
        description = newsDescription;
        publishedAt = publishDate;
        url = URL;
        urlToImage = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.author);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.publishedAt);
        dest.writeString(this.url);
        dest.writeString(this.urlToImage);
    }



    protected Articles(Parcel in) {
        this.author = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.publishedAt = in.readString();
        this.url = in.readString();
        this.urlToImage = in.readString();
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
