package com.ibtikar.app.dutchmart.ui.fragments.offers;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ibtikar.app.dutchmart.R;
import com.ibtikar.app.dutchmart.StaticValues;
import com.ibtikar.app.dutchmart.data.adapters.AdapterOffers;
import com.ibtikar.app.dutchmart.data.models.CategoryModel;
import com.ibtikar.app.dutchmart.data.models.OfferModel;
import com.ibtikar.app.dutchmart.ui.activities.base.BaseFragment;
import com.ibtikar.app.dutchmart.uiutilities.CustomRecyclerView;
import com.ibtikar.app.dutchmart.uiutilities.PaginationAdapterCallback;
import com.ibtikar.app.dutchmart.uiutilities.paginationStaggardScrollListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OffersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OffersFragment extends BaseFragment implements AdapterOffers.customButtonListener, PaginationAdapterCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.offers_list)
    CustomRecyclerView rvListOffers;

    @BindView(R.id.im_list_icon)
    ImageView btnList;
    @BindView(R.id.im_grid_icon)
    ImageView btnGridIcon;

    AdapterOffers adapter;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    LinearLayoutManager linearLayoutManager;
    private static final int PAGE_START = 1;

    private boolean isLoading = false;
    private boolean isLastPage = false;
    // limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
    private int TOTAL_PAGES = 20;
    private Integer currentPage = PAGE_START;

    private ArrayList<OfferModel> arrayList;



    Handler handler;


    public OffersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OffersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OffersFragment newInstance(String param1, String param2) {
        OffersFragment fragment = new OffersFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_offers, container, false);
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
                rvListOffers.setLayoutManager(linearLayoutManager);
                adapter.notifyDataSetChanged();
                btnList.setImageResource(R.drawable.icon_list_selected);
                btnGridIcon.setImageResource(R.drawable.icon_grid_normal);


            }
        });
        btnGridIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvListOffers.setLayoutManager(staggeredGridLayoutManager);
                adapter.notifyDataSetChanged();
                btnGridIcon.setImageResource(R.drawable.icon_grid_selected);
                btnList.setImageResource(R.drawable.icon_list_normal);


            }
        });
        rvListOffers.setLayoutManager(linearLayoutManager);
        rvListOffers.setHasFixedSize(true);

        rvListOffers.setItemViewCacheSize(20);
        rvListOffers.setDrawingCacheEnabled(true);
        rvListOffers.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        populatRecyclerView();
        implementScrolListener();

        currentPage = PAGE_START;
        presenterloadOffersFirstPage();
        super.onViewCreated(view, savedInstanceState);
    }

    public void presenterloadOffersFirstPage()
    {
        ArrayList<OfferModel> list = new ArrayList<>();
        OfferModel categoryModel = new OfferModel("1", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("3", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.flat_food_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.flat_food_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.flat_food_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.im_subcat_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.im_subcat_o_test));
        list.add(categoryModel);
        categoryModel = new OfferModel("2", BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.flat_food_test));
        list.add(categoryModel);
        list.add(categoryModel);
        getMvpViewaddMoreToAdapter(list);
    }

    private void getMvpViewaddMoreToAdapter(final ArrayList<OfferModel> list) {
                    adapter.addAll(list);
    }


    private void populatRecyclerView() {

        adapter = new AdapterOffers(getActivity(), arrayList, StaticValues.SUBCATEGORY_DATA_TYPE);
        adapter.setCustomButtonListner(this);
        adapter.setPagingAdapterCallback(this);
        rvListOffers.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void implementScrolListener()
    {
        rvListOffers.addOnScrollListener(new paginationStaggardScrollListener(staggeredGridLayoutManager) {
            @Override
            protected void hideCatList() {

            }

            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;

                presenterloadOffersNextPage(currentPage);
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

    private void presenterloadOffersNextPage(Integer currentPage) {

    }


    @Override
    public void onItemClickListner(String id) {

    }


    @Override
    public void retryPageLoad() {

    }
}
