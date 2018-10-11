package com.ibtikar.app.dutchmart.ui.fragments.subcategories;

import com.ibtikar.app.dutchmart.ui.activities.base.MvpPresenter;

public interface SubCategoriesMvpPresenter <V extends SubCategoriesMvpView> extends MvpPresenter<V> {
    void loadSubCategoriesFirstPage(String categoryId);
    void loadSubCategoriesNextPage(String id, Integer page);
}
