package com.ibtikar.app.egymart.ui.fragments.subcategories;

import com.ibtikar.app.egymart.ui.activities.base.MvpPresenter;

public interface SubCategoriesMvpPresenter <V extends SubCategoriesMvpView> extends MvpPresenter<V> {
    void loadSubCategories();
}
