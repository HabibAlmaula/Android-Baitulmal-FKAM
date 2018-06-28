package com.baitulmalfkam.baitulmalfkam.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class ListItem implements Parcelable {
    String id;
    String url;
    String title;
    String content;
    String date;
    String thumbnail;


    protected ListItem(Parcel in) {
        id = in.readString();
        url = in.readString();
        title = in.readString();
        content = in.readString();
        date = in.readString();
        thumbnail = in.readString();
    }

    public static final Creator<ListItem> CREATOR = new Parcelable.Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public ListItem(String id, String url, String title, String content, String date, String thumbnail) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.content = content;
        this.date = date;
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.url);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeString(this.date);
        dest.writeString(this.thumbnail);


    }
}
