package com.e.dhfood.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ComidaTwo implements Parcelable {

    private int imgViewTwo;

    public ComidaTwo(int imgViewTwo) {
        this.imgViewTwo = imgViewTwo;
    }



    protected ComidaTwo(Parcel in) {
        imgViewTwo= in.readInt();
    }

    public int getImgViewTwo() {
        return imgViewTwo;
    }

    public void setImgViewTwo(int imgViewTwo) {
        this.imgViewTwo = imgViewTwo;
    }

    public static final Creator<ComidaTwo> CREATOR = new Creator<ComidaTwo>() {
        @Override
        public ComidaTwo createFromParcel(Parcel in) {
            return new ComidaTwo(in);
        }

        @Override
        public ComidaTwo[] newArray(int size) {
            return new ComidaTwo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgViewTwo);

    }
}
