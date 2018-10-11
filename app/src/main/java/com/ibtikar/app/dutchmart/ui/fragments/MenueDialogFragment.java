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

import com.ibtikar.app.dutchmart.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenueDialogFragment extends DialogFragment {

    @BindView(R.id.btn_close)
    ImageView btnClose;

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

    CustomButtonListener customListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_dialog_fragment, container, false);
        ButterKnife.bind(this, rootView);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });



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

        return rootView;
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

    public interface CustomButtonListener {
        public void onItemClickListner(String title);
    }
    public void setCustomButtonListner(CustomButtonListener listener) {
        this.customListener = listener;
    }

}
