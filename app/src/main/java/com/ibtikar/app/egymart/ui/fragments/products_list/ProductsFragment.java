package com.ibtikar.app.egymart.ui.fragments.products_list;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ibtikar.app.egymart.MvpApp;
import com.ibtikar.app.egymart.R;
import com.ibtikar.app.egymart.StaticValues;
import com.ibtikar.app.egymart.data.DataManager;
import com.ibtikar.app.egymart.data.adapters.AdapterSubCategories;
import com.ibtikar.app.egymart.data.models.CategoryModel;
import com.ibtikar.app.egymart.ui.activities.base.BaseFragment;
import com.ibtikar.app.egymart.ui.fragments.ProductDetailsFragment;
import com.ibtikar.app.egymart.uiutilities.CustomRecyclerView;
import com.ibtikar.app.egymart.uiutilities.PaginationAdapterCallback;
import com.ibtikar.app.egymart.uiutilities.paginationStaggardScrollListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductsFragment extends BaseFragment implements ProductsMvpView, AdapterSubCategories.customButtonListener, PaginationAdapterCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String subCategoryId;
    private String mParam2;

    @BindView(R.id.products_list)
    CustomRecyclerView rvListProducts;

    @BindView(R.id.im_list_icon)
    ImageView btnList;
    @BindView(R.id.im_grid_icon)
    ImageView btnGridIcon;

    AdapterSubCategories adapter;

    StaggeredGridLayoutManager staggeredGridLayoutManager;
    LinearLayoutManager linearLayoutManager;
    private static final int PAGE_START = 1;

    private boolean isLoading = false;
    private boolean isLastPage = false;
    // limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
    private int TOTAL_PAGES = 20;
    private Integer currentPage = PAGE_START;

    private ArrayList<CategoryModel> arrayList;

    Handler handler;
    ProductsPresenter presenter;


    public ProductsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductsFragment newInstance(String param1, String param2) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            subCategoryId = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        handler = new Handler(Looper.getMainLooper());
        DataManager dataManager = ((MvpApp) getActivity().getApplication()).getDataManager();
        presenter = new ProductsPresenter(dataManager);
        presenter.onAttach(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_products, container, false);
        ButterKnife.bind(this, rootView);
        arrayList = new ArrayList<>();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        linearLayoutManager = new LinearLayoutManager(getContext());
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvListProducts.setLayoutManager(linearLayoutManager);
                adapter.notifyDataSetChanged();
                btnList.setImageResource(R.drawable.icon_list_selected);
                btnGridIcon.setImageResource(R.drawable.icon_grid_normal);


            }
        });
        btnGridIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvListProducts.setLayoutManager(staggeredGridLayoutManager);
                adapter.notifyDataSetChanged();
                btnGridIcon.setImageResource(R.drawable.icon_grid_selected);
                btnList.setImageResource(R.drawable.icon_list_normal);


            }
        });
        rvListProducts.setLayoutManager(staggeredGridLayoutManager);
        rvListProducts.setHasFixedSize(true);

        rvListProducts.setItemViewCacheSize(20);
        rvListProducts.setDrawingCacheEnabled(true);
        rvListProducts.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        populatRecyclerView();
        implementScrolListener();

        currentPage = PAGE_START;
        presenter.loadProductsFirstPage(subCategoryId);
        super.onViewCreated(view, savedInstanceState);
    }


    private void populatRecyclerView() {

        adapter = new AdapterSubCategories(getActivity(), arrayList, StaticValues.SUBCATEGORY_DATA_TYPE);
        adapter.setCustomButtonListner(this);
        adapter.setPagingAdapterCallback(this);
        rvListProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void implementScrolListener()
    {
        rvListProducts.addOnScrollListener(new paginationStaggardScrollListener(staggeredGridLayoutManager) {
            @Override
            protected void hideCatList() {

            }

            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;

                presenter.loadProductsNextPage(subCategoryId, currentPage);
            }

            @Override
            public int getTotalPageCount() {
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

    }


    @Override
    public void onItemClickListner(String id, String title) {
        getFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new ProductDetailsFragment(), "").addToBackStack("").commit();
    }

    @Override
    public void addMoreToAdapter(final ArrayList<CategoryModel> list) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                adapter.addAll(list);
            }
        });
    }

    @Override
    public Context passContext() {
        return getActivity();
    }

    @Override
    public void setLastPageTrue() {

    }

    @Override
    public void addLoadingFooter() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                adapter.addLoadingFooter();
            }
        });
    }

    @Override
    public void removeLoadingFooter() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                adapter.removeLoadingFooter();
            }
        });
    }

    @Override
    public void showRetryAdapter() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                adapter.showRetry(true,getString(R.string.conn_error_recyview));
            }
        });
    }

    @Override
    public void setIsLoadingFalse() {
        isLoading = false;
    }

    @Override
    public void retryPageLoad() {
        presenter.loadProductsNextPage(subCategoryId, currentPage);
    }
}
