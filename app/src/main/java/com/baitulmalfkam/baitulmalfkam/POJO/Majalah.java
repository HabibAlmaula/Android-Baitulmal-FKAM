package com.baitulmalfkam.baitulmalfkam.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class Majalah implements Parcelable {
    String id;
    String type;
    String slug;
    String url;
    String title;
    String content;
    String date;
    String thumbnail;
    String Edisi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        content.replaceAll("<>/p" ," ");
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail(){
        return thumbnail;
    }
    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }


    public String getEdisi() {
        return Edisi;
    }

    public void setEdisi(String  edisi) {
        this.Edisi = edisi;
    }

    public Majalah(String id, String type, String slug, String url, String title, String date, String thumbnail, String content) {
        this.id = id;
        this.type = type;
        this.slug = slug;
        this.url = url;
        this.title = title;
        this.date = date;
        this.thumbnail = thumbnail;
        this.content = content;

    }

    public Majalah(String id, String type, String slug, String url, String title, String date, String thumbnail, String content, String edisi){
        this.id = id;
        this.type = type;
        this.slug = slug;
        this.url = url;
        this.title = title;
        this.date = date;
        this.thumbnail = thumbnail;
        this.content = content;
        this.Edisi = edisi;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.type);
        dest.writeString(this.slug);
        dest.writeString(this.url);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.thumbnail);
        dest.writeString(this.content);
        dest.writeString(this.Edisi);
    }


    protected Majalah(Parcel in) {
        this.id = in.readString();
        this.type = in.readString();
        this.slug = in.readString();
        this.url = in.readString();
        this.title = in.readString();
        this.date = in.readString();
        this.thumbnail = in.readString();
        this.content = in.readString();
        this.Edisi = in.readString();

    }

    public static final Creator<Majalah> CREATOR = new Parcelable.Creator<Majalah>() {
        @Override
        public Majalah createFromParcel(Parcel source) {
            return new Majalah(source);
        }

        @Override
        public Majalah[] newArray(int size) {
            return new Majalah[size];
        }
    };
}
