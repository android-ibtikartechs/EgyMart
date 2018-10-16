package com.ibtikar.app.dutchmart.ui.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.ibtikar.app.dutchmart.R;
import com.ibtikar.app.dutchmart.data.adapters.MenuListAdapter;
import com.ibtikar.app.dutchmart.data.models.CategoryModel;
import com.ibtikar.app.dutchmart.data.models.MenuItemModel;
import com.ibtikar.app.dutchmart.utils.PassedDataFromCategoriesToMenu;
import com.ibtikar.app.dutchmart.utils.RxBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MenueDialogFragment extends DialogFragment implements MenuListAdapter.CustomeListener {

    @BindView(R.id.btn_close)
    ImageView btnClose;

    @BindView(R.id.lv_menu_item)
    ListView lvMenu;
/*
    @BindView(R.id.btn_home)
    ImageView btnHome;

    @BindView(R.id.btn_login_reg)
    ImageView btnLoginReg;

    @BindView(R.id.btn_offers)
    ImageView btnOffers;

    @BindView(R.id.btnCategories)
    ImageView btnCategories;

    @BindView(R.id.btn_exit)
    ImageView btnExit;
*/
    ArrayList<CategoryModel> menuItemsArrayList;
    MenuListAdapter cartListAdapter;

    CustomButtonListener customListener;
    Disposable disposable;
    ArrayList<CategoryModel> categoriesArrayList;
    PassedDataFromCategoriesToMenu data;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_dialog_fragment_sec, container, false);
        ButterKnife.bind(this, rootView);

        disposable = RxBus.subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                if (o instanceof PassedDataFromCategoriesToMenu) {
                    data= (PassedDataFromCategoriesToMenu) o;
                    //do sth with the data .. you can populate a RecycleView for example
                }
            }
        });
        disposable.dispose();

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
/*
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customListener.onItemClickListner("home");
            }
        });
        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customListener.onItemClickListner("categories");
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customListener.onItemClickListner("exit");
            }
        });
        btnLoginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customListener.onItemClickListner("loginRegister");
            }
        });
        btnOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customListener.onItemClickListner("offers");
            }
        });
*/
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menuItemsArrayList = new ArrayList<>();

        menuItemsArrayList.add(new CategoryModel("Home","-1",""));
        for (CategoryModel categoryModel : data.getCategoriesArrayList())
        {
            menuItemsArrayList.add(categoryModel);
        }
        menuItemsArrayList.add(new CategoryModel("Offers","-1",""));
        menuItemsArrayList.add(new CategoryModel("Exit","-1",""));


        cartListAdapter = new MenuListAdapter(getContext(),menuItemsArrayList);
        cartListAdapter.setCustomButtonListner(this);
        lvMenu.setAdapter(cartListAdapter);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final LinearLayout root = new LinearLayout(getActivity());
        root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(root);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        WindowManager.LayoutParams params = dialog.getWindow().getAttributes(); // change this to your dialog.

        params.y = -100; // Here is the param to set your dialog position. Same with params.x
        dialog.getWindow().setAttributes(params);
        return dialog;
    }

    @Override
    public void onItemClickListener(String title, String itemId, int position) {
        dismiss();
        customListener.onItemClickListner(title, itemId);
    }

    public interface CustomButtonListener {
        public void onItemClickListner(String title, String itemId);
    }
    public void setCustomButtonListner(CustomButtonListener listener) {
        this.customListener = listener;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose(); //very important
    }

}
