package com.ibtikar.app.egymart.ui.fragments.categoriesfragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ibtikar.app.egymart.MvpApp;
import com.ibtikar.app.egymart.R;
import com.ibtikar.app.egymart.data.DataManager;
import com.ibtikar.app.egymart.data.adapters.AdapterCategories;
import com.ibtikar.app.egymart.data.models.CategoryModel;
import com.ibtikar.app.egymart.ui.activities.base.BaseFragment;
import com.ibtikar.app.egymart.ui.fragments.ProductDetailsFragment;
import com.ibtikar.app.egymart.ui.fragments.subcategories.SubCategoriesFragment;
import com.ibtikar.app.egymart.uiutilities.CustomRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends BaseFragment implements CategoriesMvpView, AdapterCategories.CustomButtonListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.emp_lout)
    LinearLayout loutClick;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AdapterCategories newsAdapter;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    @BindView(R.id.cat_home_list)
    CustomRecyclerView catRecyclerView;

    CategoriesPresenter presenter;

    private ArrayList<CategoryModel> arrayList;
    private Handler mHandler;



    public CategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoriesFragment newInstance(String param1, String param2) {
        CategoriesFragment fragment = new CategoriesFragment();
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
        DataManager dataManager = ((MvpApp) getActivity().getApplication()).getDataManager();
        presenter = new CategoriesPresenter(dataManager);
        presenter.onAttach(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mHandler = new Handler(Looper.getMainLooper());
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        arrayList = new ArrayList<>();
        ButterKnife.bind(this,view);
        Log.d("", "onCreateView: ");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //presenter.loadCategories();
        //Toast.makeText(getActivity(), String.valueOf(arrayList.size()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        catRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        catRecyclerView.setHasFixedSize(true);
        Log.d("", "onViewCreated: ");
        populatRecyclerView();
        presenter.loadCategories();
        super.onViewCreated(view, savedInstanceState);
    }

    private void populatRecyclerView() {
        newsAdapter = new AdapterCategories(getActivity(), arrayList);
        newsAdapter.setCustomButtonListner(this);
        catRecyclerView.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemNewsClickListner(String title, String id) {
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, new SubCategoriesFragment(), "").addToBackStack(null).commit();
    }

    @Override
    public void addMoreToAdapter(final ArrayList<CategoryModel> list) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                newsAdapter.addAll(list);
            }
        });
    }

    @Override
    public Context passContext() {
       return getActivity();
    }
}
