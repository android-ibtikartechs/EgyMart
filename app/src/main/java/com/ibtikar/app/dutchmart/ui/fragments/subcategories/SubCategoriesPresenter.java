package com.ibtikar.app.dutchmart.ui.fragments.subcategories;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;

import com.ibtikar.app.dutchmart.R;
import com.ibtikar.app.dutchmart.data.DataManager;
import com.ibtikar.app.dutchmart.data.models.CategoryModel;
import com.ibtikar.app.dutchmart.ui.activities.base.BasePresenter;

import java.util.ArrayList;

public class SubCategoriesPresenter <V extends SubCategoriesMvpView> extends BasePresenter<V> implements SubCategoriesMvpPresenter<V> {
    public SubCategoriesPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void loadSubCategoriesFirstPage(String categoryId) {
        ArrayList<CategoryModel> list = new ArrayList<>();

        CategoryModel categoryModel = new CategoryModel("Cosmetics","1", "https://thumbs.dreamstime.com/t/coffee-products-jacobs-douwe-egberts-poznan-poland-oct-brand-marketed-europe-headquartered-amsterdam-netherlands-78946534.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "http://www.around-amsterdam.com/images/dutch-cheese-1000.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", "https://d2v9y0dukr6mq2.cloudfront.net/video/thumbnail/N_-wj6-wx/videoblocks-netherlands-cheese-wheel-display-in-a-row-famous-diary-product-of-amsterdam_hjl2p34zae_thumbnail-full01.png");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "https://www.cocacolanederland.nl/content/dam/journey/nl/nl/private/stories/2017/2017-vernieuwde-sprite.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "https://i4.aroq.com/3/2017-07-03-13-44-13094263_1069251323134382_829762458584806910_n_cropped_90.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", "https://cdn-a.william-reed.com/var/wrbm_gb_food_pharma/storage/images/5/1/4/0/1070415-1-eng-GB/Unilever-soup-move-boosts-aseptic-in-Netherlands_wrbm_large.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "https://cdn-a.william-reed.com/var/wrbm_gb_food_pharma/storage/images/1/9/5/8/528591-1-eng-GB/North-America-s-54bn-packaging-market-in-flux_wrbm_small.jpg");
        list.add(categoryModel);
        getMvpView().addMoreToAdapter(list);
    }

    @Override
    public void loadSubCategoriesNextPage(String id, Integer page) {

    }
}
