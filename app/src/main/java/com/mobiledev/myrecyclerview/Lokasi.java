package com.mobiledev.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Lokasi implements Parcelable {
    public String lokasi, nama, img, desc;

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.lokasi);
        dest.writeString(this.nama);
        dest.writeString(this.img);
        dest.writeString(this.desc);
    }

    public Lokasi() {
    }

    protected Lokasi(Parcel in) {
        this.lokasi = in.readString();
        this.nama = in.readString();
        this.img = in.readString();
        this.desc = in.readString();
    }

    public static final Creator<Lokasi> CREATOR = new Creator<Lokasi>() {
        @Override
        public Lokasi createFromParcel(Parcel source) {
            return new Lokasi(source);
        }

        @Override
        public Lokasi[] newArray(int size) {
            return new Lokasi[size];
        }
    };
}
