package com.ibtikar.app.egymart.ui.fragments.products_list;

import android.content.Context;

import com.ibtikar.app.egymart.data.models.CategoryModel;
import com.ibtikar.app.egymart.ui.activities.base.MvpView;

import java.util.ArrayList;

public interface ProductsMvpView extends MvpView {
    void addMoreToAdapter(ArrayList<CategoryModel> list);
    Context passContext();
    void setLastPageTrue();
    void addLoadingFooter();
    void removeLoadingFooter();
    void showRetryAdapter();
    void setIsLoadingFalse();
}
