package com.ibtikar.app.egymart;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

import com.ibtikar.app.egymart.data.DataManager;
import com.ibtikar.app.egymart.data.SharedPreferencesHelper;
import com.ibtikar.app.egymart.data.db_helper.SQLiteHandler;

import java.util.Locale;

public class MvpApp extends Application {
    DataManager dataManager;



    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesHelper sharedPrefsHelper = new SharedPreferencesHelper(getApplicationContext());
        SQLiteHandler sqliteHandler = new SQLiteHandler(getApplicationContext());
        dataManager = new DataManager(sqliteHandler, sharedPrefsHelper);
        //setLocale("ar");
        //changeLang(getApplicationContext(), "ar");
    }


    public DataManager getDataManager() {
        return dataManager;
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLayoutDirection(myLocale);
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

    }

    @SuppressWarnings("deprecation")
    private void setLocale2(String locale){
        Locale mLocale = new Locale(locale);
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            configuration.setLocale(mLocale);
        } else{
            configuration.locale=mLocale;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            getApplicationContext().createConfigurationContext(configuration);
        } else {
            resources.updateConfiguration(configuration,displayMetrics);
        }
    }

    public ContextWrapper changeLang(Context context, String lang_code) {
        Locale sysLocale;

        Resources rs = context.getResources();
        Configuration config = rs.getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            sysLocale = config.getLocales().get(0);
        } else {
            sysLocale = config.locale;
        }
        if (!lang_code.equals("") && !sysLocale.getLanguage().equals(lang_code)) {
            Locale locale = new Locale(lang_code);
            Locale.setDefault(locale);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                config.setLocale(locale);
            } else {
                config.locale = locale;
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                context = context.createConfigurationContext(config);
            } else {
                context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
            }
        }

        return new ContextWrapper(context);
    }

}