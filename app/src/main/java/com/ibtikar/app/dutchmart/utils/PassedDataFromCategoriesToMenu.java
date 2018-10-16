package com.ibtikar.app.dutchmart.utils;

import com.ibtikar.app.dutchmart.data.models.CategoryModel;

import java.util.ArrayList;

public class PassedDataFromCategoriesToMenu {
    private ArrayList<CategoryModel> categoriesArrayList;

    public PassedDataFromCategoriesToMenu(ArrayList<CategoryModel> categoriesArrayList) {
        this.categoriesArrayList = categoriesArrayList;
    }

    public ArrayList<CategoryModel> getCategoriesArrayList() {
        return categoriesArrayList;
    }
}
