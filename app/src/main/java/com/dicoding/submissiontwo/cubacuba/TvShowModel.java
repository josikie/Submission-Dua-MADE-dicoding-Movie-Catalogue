package com.dicoding.submissiontwo.cubacuba;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowModel implements Parcelable {
    private String titleTvShow;
    private String genreTvShow;
    private String descTvShow;
    private int imgTvShow;

    public TvShowModel() {

    }

    public int getImgTvShow() {
        return imgTvShow;
    }

    public void setImgTvShow(int imgTvShow) {
        this.imgTvShow = imgTvShow;
    }

    public String getTitleTvShow() {
        return titleTvShow;
    }

    public void setTitleTvShow(String titleTvShow) {
        this.titleTvShow = titleTvShow;
    }

    public String getGenreTvShow() {
        return genreTvShow;
    }

    public void setGenreTvShow(String genreTvShow) {
        this.genreTvShow = genreTvShow;
    }

    public String getDescTvShow() {
        return descTvShow;
    }

    public void setDescTvShow(String descTvShow) {
        this.descTvShow = descTvShow;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.titleTvShow);
        parcel.writeString(this.genreTvShow);
        parcel.writeString(this.descTvShow);
        parcel.writeInt(this.imgTvShow);
    }

    protected TvShowModel(Parcel in) {
        this.titleTvShow = in.readString();
        this.genreTvShow = in.readString();
        this.descTvShow = in.readString();
        this.imgTvShow = in.readInt();
    }

    public static final Creator<TvShowModel> CREATOR = new Creator<TvShowModel>() {
        @Override
        public TvShowModel createFromParcel(Parcel in) {
            return new TvShowModel(in);
        }

        @Override
        public TvShowModel[] newArray(int size) {
            return new TvShowModel[size];
        }
    };
}
