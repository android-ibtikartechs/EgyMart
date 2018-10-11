package com.ibtikar.app.dutchmart.ui.activities.main;

import com.ibtikar.app.dutchmart.data.DataManager;
import com.ibtikar.app.dutchmart.ui.activities.base.BasePresenter;

public class MainPresenter <V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    private final String TAG = MainPresenter.class.getSimpleName();

    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
