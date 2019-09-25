package com.nofi.submissionandroidpemula.model;

import android.os.Parcel;
import android.os.Parcelable;

public class WisataKudus implements Parcelable {
    private int iv_imgWisataKudus, iv_backdropWisataKudus;
    private String tv_namaWisataKudus, tv_JenisWisataKudus, tv_deskripsiWisataKudus, tv_AlamatWisataKudus;

    public WisataKudus() {
    }

    private WisataKudus(Parcel in) {
        iv_imgWisataKudus = in.readInt();
        iv_backdropWisataKudus = in.readInt();
        tv_namaWisataKudus = in.readString();
        tv_JenisWisataKudus = in.readString();
        tv_deskripsiWisataKudus = in.readString();
        tv_AlamatWisataKudus = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(iv_imgWisataKudus);
        dest.writeInt(iv_backdropWisataKudus);
        dest.writeString(tv_namaWisataKudus);
        dest.writeString(tv_JenisWisataKudus);
        dest.writeString(tv_deskripsiWisataKudus);
        dest.writeString(tv_AlamatWisataKudus);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WisataKudus> CREATOR = new Creator<WisataKudus>() {
        @Override
        public WisataKudus createFromParcel(Parcel in) {
            return new WisataKudus(in);
        }

        @Override
        public WisataKudus[] newArray(int size) {
            return new WisataKudus[size];
        }
    };

    public int getIv_imgWisataKudus() {
        return iv_imgWisataKudus;
    }

    public void setIv_imgWisataKudus(int iv_imgWisataKudus) {
        this.iv_imgWisataKudus = iv_imgWisataKudus;
    }

    public int getIv_backdropWisataKudus() {
        return iv_backdropWisataKudus;
    }

    public void setIv_backdropWisataKudus(int iv_backdropWisataKudus) {
        this.iv_backdropWisataKudus = iv_backdropWisataKudus;
    }

    public String getTv_namaWisataKudus() {
        return tv_namaWisataKudus;
    }

    public void setTv_namaWisataKudus(String tv_namaWisataKudus) {
        this.tv_namaWisataKudus = tv_namaWisataKudus;
    }

    public String getTv_JenisWisataKudus() {
        return tv_JenisWisataKudus;
    }

    public void setTv_JenisWisataKudus(String tv_JenisWisataKudus) {
        this.tv_JenisWisataKudus = tv_JenisWisataKudus;
    }

    public String getTv_deskripsiWisataKudus() {
        return tv_deskripsiWisataKudus;
    }

    public void setTv_deskripsiWisataKudus(String tv_deskripsiWisataKudus) {
        this.tv_deskripsiWisataKudus = tv_deskripsiWisataKudus;
    }

    public String getTv_AlamatWisataKudus() {
        return tv_AlamatWisataKudus;
    }

    public void setTv_AlamatWisataKudus(String tv_AlamatWisataKudus) {
        this.tv_AlamatWisataKudus = tv_AlamatWisataKudus;
    }

    public static Creator<WisataKudus> getCREATOR() {
        return CREATOR;
    }
}
