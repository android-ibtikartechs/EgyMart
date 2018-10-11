package com.ibtikar.app.dutchmart.ui.fragments.subcategories;

import android.content.Context;

import com.ibtikar.app.dutchmart.data.models.CategoryModel;
import com.ibtikar.app.dutchmart.ui.activities.base.MvpView;

import java.util.ArrayList;

public interface SubCategoriesMvpView extends MvpView {
    void addMoreToAdapter(ArrayList<CategoryModel> list);
    Context passContext();
    void setLastPageTrue();
    void addLoadingFooter();
    void removeLoadingFooter();
    void showRetryAdapter();
    void setIsLoadingFalse();
}
