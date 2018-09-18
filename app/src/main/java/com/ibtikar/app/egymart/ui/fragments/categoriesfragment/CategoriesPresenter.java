package com.ibtikar.app.egymart.ui.fragments.categoriesfragment;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;

import com.ibtikar.app.egymart.R;
import com.ibtikar.app.egymart.data.DataManager;
import com.ibtikar.app.egymart.data.models.CategoryModel;
import com.ibtikar.app.egymart.ui.activities.base.BasePresenter;

import java.util.ArrayList;

public class CategoriesPresenter <V extends CategoriesMvpView> extends BasePresenter<V> implements CategoriesMvpPresenter<V> {

    private final String TAG = CategoriesPresenter.class.getSimpleName();

    public CategoriesPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void loadCategories() {
        ArrayList<CategoryModel> list = new ArrayList<>();
        CategoryModel categoryModel = new CategoryModel("Cosmetics","1", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.beauty));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.box));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.foodd));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.box));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.foodd));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.box));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.foodd));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.box));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.foodd));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.box));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.foodd));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.box));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.foodd));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.box));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.foodd));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.box));
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", BitmapFactory.decodeResource(((AppCompatActivity)getMvpView().passContext()).getResources(), R.drawable.foodd));
        list.add(categoryModel);
        getMvpView().addMoreToAdapter(list);
    }
}
