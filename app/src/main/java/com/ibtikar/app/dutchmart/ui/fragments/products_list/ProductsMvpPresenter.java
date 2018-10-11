package com.ibtikar.app.dutchmart.ui.fragments.products_list;

import com.ibtikar.app.dutchmart.ui.activities.base.MvpPresenter;

public interface ProductsMvpPresenter <V extends ProductsMvpView> extends MvpPresenter<V> {
    void loadProductsFirstPage(String categoryId);
    void loadProductsNextPage(String id, Integer page);
}
