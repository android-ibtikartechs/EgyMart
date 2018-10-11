package com.ibtikar.app.dutchmart.data.models;

import android.graphics.Bitmap;

public class CategoryModel  {
    private String title;
    private String id;
    private Bitmap im;
    private String imgUrl;

    public CategoryModel(String title, String id, Bitmap im) {
        this.title = title;
        this.id = id;
        this.im = im;
    }

    public CategoryModel(String title, String id, String imgUrl) {
        this.title = title;
        this.id = id;
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public Bitmap getIm() {
        return im;
    }
}
