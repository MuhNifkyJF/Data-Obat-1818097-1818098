package com.example.obatind;

public class Obat {
    private String mId, mNama,mJenis,mGuna;

    public Obat(String mId, String mNama, String mJenis, String mGuna) {
        this.mId = mId;
        this.mNama = mNama;
        this.mJenis = mJenis;
        this.mGuna = mGuna;
    }
    public Obat(){

    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmNama() {
        return mNama;
    }

    public void setmNama(String mNama) {
        this.mNama = mNama;
    }

    public String getmJenis() {
        return mJenis;
    }

    public void setmJenis(String mJenis) {
        this.mJenis = mJenis;
    }

    public String getmGuna() {
        return mGuna;
    }

    public void setmGuna(String mGuna) {
        this.mGuna = mGuna;
    }
}
