package com.ibtikar.app.egymart.ui.fragments.subcategories;

import com.ibtikar.app.egymart.data.DataManager;
import com.ibtikar.app.egymart.ui.activities.base.BasePresenter;

public class SubCategoriesPresenter <V extends SubCategoriesMvpView> extends BasePresenter<V> implements SubCategoriesMvpPresenter<V> {
    public SubCategoriesPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void loadSubCategories() {

    }
}
