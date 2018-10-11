package com.ibtikar.app.dutchmart.ui.fragments.categoriesfragment;

import android.content.Context;

import com.ibtikar.app.dutchmart.data.models.CategoryModel;
import com.ibtikar.app.dutchmart.ui.activities.base.MvpView;

import java.util.ArrayList;

public interface CategoriesMvpView extends MvpView {
    void addMoreToAdapter(ArrayList<CategoryModel> list);
    Context passContext();
}
