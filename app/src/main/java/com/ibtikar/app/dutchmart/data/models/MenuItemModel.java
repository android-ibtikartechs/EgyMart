package com.ibtikar.app.dutchmart.data.models;

public class MenuItemModel {
    private String id;
    private String title;

    public MenuItemModel(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
