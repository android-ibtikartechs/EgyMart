package com.ibtikar.app.dutchmart.ui.activities.base;

import com.ibtikar.app.dutchmart.data.DataManager;

public class BasePresenter <V extends MvpView> implements MvpPresenter<V> {
    DataManager mDataManager;
    private V mMvpView;

    public BasePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }



    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }
}
