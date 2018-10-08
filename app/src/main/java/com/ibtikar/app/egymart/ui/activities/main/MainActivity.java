package com.ibtikar.app.egymart.ui.activities.main;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ibtikar.app.egymart.R;
import com.ibtikar.app.egymart.ui.fragments.categoriesfragment.CategoriesFragment;
import com.ibtikar.app.egymart.ui.fragments.MenueDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_toolbar)
    Toolbar toolbar;

    TextView textCartItemCount;



    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler(Looper.getMainLooper());
        ButterKnife.bind(this);
        setupActionBar();
        getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, new CategoriesFragment(), "men").commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        final MenuItem cartItem = menu.findItem(R.id.action_cart);
        View actionView = MenuItemCompat.getActionView(cartItem);
        textCartItemCount = actionView.findViewById(R.id.cart_badge);
        setupBadge();
        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(cartItem);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart :
               /* FragmentManager fm = getSupportFragmentManager();
                SearchDialogFragment searchDialogFragment = new SearchDialogFragment();
                searchDialogFragment.show(fm, "alert"); */
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupBadge() {
    }


    public void setupActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.icon_left);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((getSupportFragmentManager().findFragmentByTag("menu_dialog"))== null ) {
                    FragmentManager fm = getSupportFragmentManager();
                    MenueDialogFragment menuDialogFragment = new MenueDialogFragment();
                    menuDialogFragment.show(fm, "menu_dialog");
                }
            }
        });

    }

}
