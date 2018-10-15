package com.ibtikar.app.dutchmart.ui.activities.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ibtikar.app.dutchmart.utils.LanguageHelper;

public class BaseActivity extends AppCompatActivity implements MvpView {
    @Override
    protected void attachBaseContext(Context newBase) {
       /* String lang_code = "ar"; //load it from SharedPref
        Locale locale = new Locale(lang_code);
        MyContextWrapper myContextWrapper = new MyContextWrapper(newBase);
        Context context = myContextWrapper.wrap(newBase,lang_code);
        super.attachBaseContext(context); */

       //Context context = LanguageHelper.updateLanguage(newBase, "ar");
        super.attachBaseContext(newBase);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
