package com.ibtikar.app.egymart.ui.fragments.products_list;

import com.ibtikar.app.egymart.ui.activities.base.MvpPresenter;

public interface ProductsMvpPresenter <V extends ProductsMvpView> extends MvpPresenter<V> {
    void loadProductsFirstPage(String categoryId);
    void loadProductsNextPage(String id, Integer page);
}
