package com.ibtikar.app.dutchmart.ui.fragments.categoriesfragment;

import com.ibtikar.app.dutchmart.ui.activities.base.MvpPresenter;

public interface CategoriesMvpPresenter <V extends CategoriesMvpView> extends MvpPresenter<V> {
    void loadCategories();
}
