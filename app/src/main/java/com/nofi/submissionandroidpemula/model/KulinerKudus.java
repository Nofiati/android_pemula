package com.nofi.submissionandroidpemula.model;

import android.os.Parcel;
import android.os.Parcelable;

public class KulinerKudus implements Parcelable {
    private int iv_imgKulinerKudus, iv_backdropKulinerKudus;
    private String tv_namaKulinerKudus, tv_JenisKulinerKudus, tv_deskripsiKulinerKudus, tv_AlamatKulinerKudus;

    public KulinerKudus() {
    }

    private KulinerKudus(Parcel in) {
        iv_imgKulinerKudus = in.readInt();
        iv_backdropKulinerKudus = in.readInt();
        tv_namaKulinerKudus = in.readString();
        tv_JenisKulinerKudus = in.readString();
        tv_deskripsiKulinerKudus = in.readString();
        tv_AlamatKulinerKudus = in.readString();
    }

    public KulinerKudus(int tv_imgKulinerKudus, int tv_backdropKulinerKudus, String tv_namaKulinerKudus, String tv_JenisKulinerKudus, String tv_deskripsiKulinerKudus, String tv_AlamatKulinerKudus) {
        this.iv_imgKulinerKudus = tv_imgKulinerKudus;
        this.iv_backdropKulinerKudus = tv_backdropKulinerKudus;
        this.tv_namaKulinerKudus = tv_namaKulinerKudus;
        this.tv_JenisKulinerKudus = tv_JenisKulinerKudus;
        this.tv_deskripsiKulinerKudus = tv_deskripsiKulinerKudus;
        this.tv_AlamatKulinerKudus = tv_AlamatKulinerKudus;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(iv_imgKulinerKudus);
        dest.writeInt(iv_backdropKulinerKudus);
        dest.writeString(tv_namaKulinerKudus);
        dest.writeString(tv_JenisKulinerKudus);
        dest.writeString(tv_deskripsiKulinerKudus);
        dest.writeString(tv_AlamatKulinerKudus);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<KulinerKudus> CREATOR = new Creator<KulinerKudus>() {
        @Override
        public KulinerKudus createFromParcel(Parcel in) {
            return new KulinerKudus(in);
        }

        @Override
        public KulinerKudus[] newArray(int size) {
            return new KulinerKudus[size];
        }
    };

    public int getIv_imgKulinerKudus() {
        return iv_imgKulinerKudus;
    }

    public void setIv_imgKulinerKudus(int tv_imgKulinerKudus) {
        this.iv_imgKulinerKudus = tv_imgKulinerKudus;
    }

    public int getIv_backdropKulinerKudus() {
        return iv_backdropKulinerKudus;
    }

    public void setIv_backdropKulinerKudus(int tv_backdropKulinerKudus) {
        this.iv_backdropKulinerKudus = tv_backdropKulinerKudus;
    }

    public String getTv_namaKulinerKudus() {
        return tv_namaKulinerKudus;
    }

    public void setTv_namaKulinerKudus(String tv_namaKulinerKudus) {
        this.tv_namaKulinerKudus = tv_namaKulinerKudus;
    }

    public String getTv_JenisKulinerKudus() {
        return tv_JenisKulinerKudus;
    }

    public void setTv_JenisKulinerKudus(String tv_JenisKulinerKudus) {
        this.tv_JenisKulinerKudus = tv_JenisKulinerKudus;
    }

    public String getTv_deskripsiKulinerKudus() {
        return tv_deskripsiKulinerKudus;
    }

    public void setTv_deskripsiKulinerKudus(String tv_deskripsiKulinerKudus) {
        this.tv_deskripsiKulinerKudus = tv_deskripsiKulinerKudus;
    }

    public String getTv_AlamatKulinerKudus() {
        return tv_AlamatKulinerKudus;
    }

    public void setTv_AlamatKulinerKudus(String tv_AlamatKulinerKudus) {
        this.tv_AlamatKulinerKudus = tv_AlamatKulinerKudus;
    }

    public static Creator<KulinerKudus> getCREATOR() {
        return CREATOR;
    }
}