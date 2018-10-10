package com.ibtikar.app.egymart.ui.fragments.products_list;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;

import com.ibtikar.app.egymart.R;
import com.ibtikar.app.egymart.data.DataManager;
import com.ibtikar.app.egymart.data.models.CategoryModel;
import com.ibtikar.app.egymart.ui.activities.base.BasePresenter;

import java.util.ArrayList;

public class ProductsPresenter <V extends ProductsMvpView> extends BasePresenter<V> implements ProductsMvpPresenter<V> {
    public ProductsPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void loadProductsFirstPage(String categoryId) {
        ArrayList<CategoryModel> list = new ArrayList<>();
        CategoryModel categoryModel = new CategoryModel("Cosmetics","1", "https://petersgourmetmarket.com/wp-content/uploads/2015/07/DSC_2595.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "https://static.shoplightspeed.com/shops/618750/files/008894922/image.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", "https://static.shoplightspeed.com/shops/618750/files/008898824/image.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "https://static.shoplightspeed.com/shops/618750/files/008898632/image.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", "https://static.shoplightspeed.com/shops/618750/files/010297995/image.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "https://petersgourmetmarket.com/wp-content/uploads/2015/06/DSC_2517.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", "https://petersgourmetmarket.com/wp-content/uploads/2015/06/DSC_2509.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "https://petersgourmetmarket.com/wp-content/uploads/2015/06/DSC_2541.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", "https://petersgourmetmarket.com/wp-content/uploads/2015/06/DSC_2579.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "https://withlocals-com-res.cloudinary.com/image/upload/c_fill,f_auto,fl_progressive,g_auto,h_200,q_auto,r_0.0,w_200/475cbbd3b25567a95739ce2a8252e9eb");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", "https://image.ec21.com/image/feliendoum/bimg_GC09197748_CA09197756/Netherlands-Nutrilon-Friso.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Souvenir","2", "https://www.vmt.nl/-/media/DE46F0FFBCB3F6ED5A0EE1CEEC40CA1A.jpg");
        list.add(categoryModel);
        categoryModel = new CategoryModel("Food","2", "https://my-live.slatic.net/p/18/mr-muscle-advanced-citrus-toilet-cleaner-2-x-500ml-netherland-1914-114064451-96c081dc8dd3a9eacd1ab5c61ba19bb3-product.jpg");
        list.add(categoryModel);
        getMvpView().addMoreToAdapter(list);
    }

    @Override
    public void loadProductsNextPage(String id, Integer page) {

    }
}
