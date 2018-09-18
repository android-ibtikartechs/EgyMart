package com.ibtikar.app.egymart.ui.fragments.categoriesfragment;

import com.ibtikar.app.egymart.ui.activities.base.MvpPresenter;

public interface CategoriesMvpPresenter <V extends CategoriesMvpView> extends MvpPresenter<V> {
    void loadCategories();
}
