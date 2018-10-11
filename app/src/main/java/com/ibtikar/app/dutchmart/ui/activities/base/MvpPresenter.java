package com.ibtikar.app.dutchmart.ui.activities.base;

public interface MvpPresenter <V extends MvpView> {
    void onAttach(V mvpView);
}
