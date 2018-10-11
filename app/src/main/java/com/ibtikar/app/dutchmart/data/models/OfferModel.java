package com.ibtikar.app.dutchmart.data.models;

import android.graphics.Bitmap;

public class OfferModel {
    private String id;
    private Bitmap img;
    private String imgUrl;

    public OfferModel(String id, Bitmap img) {
        this.id = id;
        this.img = img;
    }

    public OfferModel(String id, String imgUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getId() {
        return id;
    }

    public Bitmap getImg() {
        return img;
    }
}
