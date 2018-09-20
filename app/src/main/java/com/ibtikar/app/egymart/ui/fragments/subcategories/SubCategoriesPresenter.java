package com.ibtikar.app.egymart.ui.fragments.subcategories;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;

import com.ibtikar.app.egymart.R;
import com.ibtikar.app.egymart.data.DataManager;
import com.ibtikar.app.egymart.data.models.CategoryModel;
import com.ibtikar.app.egymart.ui.activities.base.BasePresenter;

import java.util.ArrayList;

public class SubCategoriesPresenter <V extends SubCategoriesMvpView> extends BasePresenter<V> implements SubCategoriesMvpPresenter<V> {
    public SubCategoriesPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void loadSubCategoriesFirstPage(String categoryId) {
        ArrayList<CategoryModel> list = new ArrayList<>();
        CategoryModel categoryModel = new CategoryModel("Cosmetics","1", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.flat_food_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.flat_food_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.flat_food_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.flat_food_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.flat_food_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        getMvpView().addMoreToAdapter(list);
    }

    @Override
    public void loadSubCategoriesNextPage(String id, Integer page) {

    }
}
