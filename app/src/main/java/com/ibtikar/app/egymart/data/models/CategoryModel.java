package com.ibtikar.app.egymart.data.models;

import android.graphics.Bitmap;

public class CategoryModel  {
    private String title;
    private String id;
    private Bitmap im;

    public CategoryModel(String title, String id, Bitmap im) {
        this.title = title;
        this.id = id;
        this.im = im;
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
