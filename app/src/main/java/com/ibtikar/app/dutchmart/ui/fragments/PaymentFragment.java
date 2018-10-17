package com.ibtikar.app.dutchmart.ui.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.ibtikar.app.dutchmart.R;
import com.ibtikar.app.dutchmart.data.adapters.PaymentMethodsListAdapter;
import com.ibtikar.app.dutchmart.data.models.CreditsItemModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaymentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaymentFragment extends Fragment implements PaymentMethodsListAdapter.CustomeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.btn_add_payment)
    Button btnAddPayment;

    @BindView(R.id.lv_payment_methods)
    ListView lvMenu;

    ArrayList<CreditsItemModel> menuItemsArrayList;
    PaymentMethodsListAdapter cartListAdapter;

    public PaymentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PaymentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaymentFragment newInstance(String param1, String param2) {
        PaymentFragment fragment = new PaymentFragment();
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
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_payment_sec, container, false);
        ButterKnife.bind(this,rootView);
        btnAddPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack(getFragmentManager().getBackStackEntryAt(0).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });
        return rootView;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menuItemsArrayList = new ArrayList<>();
        menuItemsArrayList.add(new CreditsItemModel("1","visa***9011"));
        menuItemsArrayList.add(new CreditsItemModel("2","visa***9077"));
        menuItemsArrayList.add(new CreditsItemModel("3","visa***9123"));
        menuItemsArrayList.add(new CreditsItemModel("-1","Paypal"));
        menuItemsArrayList.add(new CreditsItemModel("-2","Cash on delivery"));


        cartListAdapter = new PaymentMethodsListAdapter(getContext(),menuItemsArrayList);
        cartListAdapter.setCustomButtonListner(this);
        lvMenu.setAdapter(cartListAdapter);
    }

    @Override
    public void onItemClickListener(String title, String itemId, int position) {

    }
}
