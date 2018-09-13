package com.ibtikar.app.egymart.ui.activities.main;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ibtikar.app.egymart.R;
import com.ibtikar.app.egymart.ui.fragments.MenueDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        MenueDialogFragment searchDialogFragment = new MenueDialogFragment();
        searchDialogFragment.show(fm, "menu_dialog");
    }
}
