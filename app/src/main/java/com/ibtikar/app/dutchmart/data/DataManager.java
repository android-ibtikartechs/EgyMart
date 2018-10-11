package com.ibtikar.app.dutchmart.data;

import android.net.Uri;

import com.ibtikar.app.dutchmart.data.db_helper.SQLiteHandler;

public class DataManager {
    private SharedPreferencesHelper sharedPrefsHelper;
    private SQLiteHandler mSQLiteHandler;

    public DataManager(SQLiteHandler mSQLiteHandler, SharedPreferencesHelper sharedPrefsHelper) {
        this.sharedPrefsHelper = sharedPrefsHelper;
        this.mSQLiteHandler = mSQLiteHandler;
    }


}
