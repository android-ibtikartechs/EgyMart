package com.ibtikar.app.egymart.ui.fragments.categoriesfragment;

import android.content.Context;

import com.ibtikar.app.egymart.data.models.CategoryModel;
import com.ibtikar.app.egymart.ui.activities.base.MvpView;

import java.util.ArrayList;

public interface CategoriesMvpView extends MvpView {
    void addMoreToAdapter(ArrayList<CategoryModel> list);
    Context passContext();
}
