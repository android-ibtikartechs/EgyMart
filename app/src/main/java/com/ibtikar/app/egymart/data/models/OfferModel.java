package com.ibtikar.app.egymart.data.models;

import android.graphics.Bitmap;

public class OfferModel {
    private String id;
    private Bitmap imgUrl;

    public OfferModel(String id, Bitmap imgUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public Bitmap getImgUrl() {
        return imgUrl;
    }
}
