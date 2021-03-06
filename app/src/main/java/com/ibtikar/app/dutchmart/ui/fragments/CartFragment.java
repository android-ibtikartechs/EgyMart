package com.ibtikar.app.dutchmart.ui.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibtikar.app.dutchmart.R;
import com.ibtikar.app.dutchmart.data.adapters.CartItemsAdapter;
import com.ibtikar.app.dutchmart.data.models.CartItemModel;
import com.ibtikar.app.dutchmart.ui.fragments.products_list.ProductsFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment implements CartItemsAdapter.CustomeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

 /*   @BindView(R.id.btn_product)
    ImageView btnProd;

    @BindView(R.id.btn_product1)
    ImageView btnProd1;

    @BindView(R.id.btn_product2)
    ImageView btnProd2;

    @BindView(R.id.btnPlaceOrder)
    ImageView btnPlaceOrder; */

    @BindView(R.id.lv_cart_list)
    ListView lvCartList;

    @BindView(R.id.btn_place_order)
    RelativeLayout btnPlaceOrder;

    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;

    String totalPrice;

    ArrayList<CartItemModel> cartItemsArrayList;
    CartItemsAdapter cartListAdapter;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_cart_sec, container, false);
        ButterKnife.bind(this, rootView);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.main_fragment_container, new AddAddressFragment(), "").addToBackStack("").commit();
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cartItemsArrayList = new ArrayList<>();
        cartItemsArrayList.add(new CartItemModel("product", 300, 1,"https://petersgourmetmarket.com/wp-content/uploads/2015/07/DSC_2595.jpg","2"));
        cartItemsArrayList.add(new CartItemModel("product", 20, 1,"https://static.shoplightspeed.com/shops/618750/files/008894922/image.jpg","2"));
        cartItemsArrayList.add(new CartItemModel("product", 30, 1,"https://static.shoplightspeed.com/shops/618750/files/008898824/image.jpg","2"));
        cartItemsArrayList.add(new CartItemModel("product", 5, 1,"https://static.shoplightspeed.com/shops/618750/files/008898632/image.jpg","2"));
        cartItemsArrayList.add(new CartItemModel("product", 10, 1,"https://static.shoplightspeed.com/shops/618750/files/010297995/image.jpg","2"));
        cartItemsArrayList.add(new CartItemModel("product", 20, 1,"https://petersgourmetmarket.com/wp-content/uploads/2015/07/DSC_2595.jpg","2"));
        cartItemsArrayList.add(new CartItemModel("product", 8, 1,"https://petersgourmetmarket.com/wp-content/uploads/2015/07/DSC_2595.jpg","2"));
        cartListAdapter = new CartItemsAdapter(getContext(),cartItemsArrayList);
        cartListAdapter.setCustomButtonListner(this);
        lvCartList.setAdapter(cartListAdapter);
        updateTotalPrice();
    }

    @Override
    public void onRemoveButtonClickListner(String productId, int position) {

    }

    @Override
    public void onAmountEditListener(Integer currentQuantity,  int position) {
        Log.d("", "onAmountEditListener: " + currentQuantity);
        cartItemsArrayList.get(position).setQuantity(currentQuantity);
        ((TextView) getViewByPosition(position,lvCartList).findViewById(R.id.tv_quantity)).setText(cartItemsArrayList.get(position).getQuantity().toString());
        ((TextView) getViewByPosition(position, lvCartList).findViewById(R.id.tv_total_quantity_price)).setText(String.valueOf(cartItemsArrayList.get(position).getPriceForTotalQuantity()));
        updateTotalPrice();
    }

    @Override
    public void onItemClickListener(String productId) {
        getFragmentManager().beginTransaction().add(R.id.main_fragment_container, new ProductDetailsFragment(), "").addToBackStack("").commit();
    }

    public void updateTotalPrice ()
    {
        Integer totalPrice = 0;
        for (int i =0; i<cartItemsArrayList.size(); i++)
        {
            totalPrice += cartItemsArrayList.get(i).getPriceForTotalQuantity();
        }
        tvTotalPrice.setText(totalPrice.toString());
    }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

}
