package com.ibtikar.app.egymart.ui.activities.base;

public interface MvpPresenter <V extends MvpView> {
    void onAttach(V mvpView);
}
