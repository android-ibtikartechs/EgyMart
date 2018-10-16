package com.ibtikar.app.dutchmart.ui.activities.main;

import android.content.Intent;
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

import com.ibtikar.app.dutchmart.R;
import com.ibtikar.app.dutchmart.ui.activities.base.BaseActivity;
import com.ibtikar.app.dutchmart.ui.fragments.CartFragment;
import com.ibtikar.app.dutchmart.ui.fragments.LoginFragment;
import com.ibtikar.app.dutchmart.ui.fragments.categoriesfragment.CategoriesFragment;
import com.ibtikar.app.dutchmart.ui.fragments.MenueDialogFragment;
import com.ibtikar.app.dutchmart.ui.fragments.offers.OffersFragment;
import com.ibtikar.app.dutchmart.ui.fragments.subcategories.SubCategoriesFragment;
import com.ibtikar.app.dutchmart.utils.PassedDataFromCategoriesToMenu;
import com.ibtikar.app.dutchmart.utils.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity implements MenueDialogFragment.CustomButtonListener {
    @BindView(R.id.main_toolbar)
    Toolbar toolbar;

    TextView textCartItemCount;

    MenueDialogFragment menueDialogFragment;

    Disposable disposable;
    PassedDataFromCategoriesToMenu data;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler(Looper.getMainLooper());
        ButterKnife.bind(this);


       /* disposable = RxBus.subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                if (o instanceof PassedDataFromCategoriesToMenu) {
                    data= (PassedDataFromCategoriesToMenu) o;
                    //do sth with the data .. you can populate a RecycleView for example
                }
            }
        });

        RxBus.publish(data);

        disposable.dispose();
*/

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
                if ((getSupportFragmentManager().findFragmentByTag("cart_fragment"))== null ) {
                    getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, new LoginFragment(), "login_fragment").addToBackStack("").commit();
                }
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
                    menueDialogFragment = new MenueDialogFragment();
                    menueDialogFragment.setCustomButtonListner(MainActivity.this);
                    menueDialogFragment.show(fm, "menu_dialog");
                }
            }
        });

    }


    @Override
    public void onItemClickListner(String title, String itemId) {
        menueDialogFragment.dismiss();
        if (itemId.equals("-1"))
        {
            switch (title) {
                case "Home":
                    if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
                        //getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, new CategoriesFragment(), "men").commit();
                        getSupportFragmentManager().popBackStack(getSupportFragmentManager().getBackStackEntryAt(0).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    }
                    break;

                case "Exit":
                    Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                    homeIntent.addCategory(Intent.CATEGORY_HOME);
                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(homeIntent);
                    break;

                case "Offers":
                    getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, new OffersFragment(), "offers_fragment").addToBackStack(null).commit();
                    break;
            }
        }
        else
            getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, new SubCategoriesFragment(), "subcategories_fragment").addToBackStack(null).commit();
    }
}
