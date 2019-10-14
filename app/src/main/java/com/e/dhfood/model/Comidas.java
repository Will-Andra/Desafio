package com.e.dhfood.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Comidas implements Parcelable {

    private String txNomeRest;
    private String txtAvenidaRest;
    private String txtHorarioRest;
    private int imgViewLocal;

    public Comidas(String txNomeRest, String txtAvenidaRest, String txtHorarioRest, int imgViewLocal) {
        this.txNomeRest = txNomeRest;
        this.txtAvenidaRest = txtAvenidaRest;
        this.txtHorarioRest = txtHorarioRest;
        this.imgViewLocal = imgViewLocal;
    }

    protected Comidas(Parcel in) {
        txNomeRest = in.readString();
        txtAvenidaRest = in.readString();
        txtHorarioRest = in.readString();
        imgViewLocal = in.readInt();
    }

    public String getTxNomeRest() {
        return txNomeRest;
    }

    public String getTxtAvenidaRest() {
        return txtAvenidaRest;
    }

    public String getTxtHorarioRest() {
        return txtHorarioRest;
    }

    public int getImgViewLocal() {
        return imgViewLocal;
    }

    public void setTxNomeRest(String txNomeRest) {
        this.txNomeRest = txNomeRest;
    }

    public void setTxtAvenidaRest(String txtAvenidaRest) {
        this.txtAvenidaRest = txtAvenidaRest;
    }

    public void setTxtHorarioRest(String txtHorarioRest) {
        this.txtHorarioRest = txtHorarioRest;
    }

    public void setImgViewLocal(int imgViewLocal) {
        this.imgViewLocal = imgViewLocal;
    }



    public static final Creator<Comidas> CREATOR = new Creator<Comidas>() {
        @Override
        public Comidas createFromParcel(Parcel in) {
            return new Comidas(in);
        }

        @Override
        public Comidas[] newArray(int size) {
            return new Comidas[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(txNomeRest);
        parcel.writeString(txtAvenidaRest);
        parcel.writeString(txtHorarioRest);
        parcel.writeInt(imgViewLocal);

    }
}
