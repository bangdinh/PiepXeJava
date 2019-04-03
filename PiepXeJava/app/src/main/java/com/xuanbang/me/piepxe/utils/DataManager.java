package com.xuanbang.me.piepxe.utils;

import android.content.Context;

import com.xuanbang.me.piepxe.utils.helper.SharedPrefsHelper;

import javax.inject.Inject;
import javax.inject.Named;

import static com.xuanbang.me.util.Constant.APP_CONTEXT;

public class DataManager {

    private Context mContext;
    //    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@Named(APP_CONTEXT) Context context,
//                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {
        mContext = context;
//        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken() {
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

//    public Long createUser(User user) throws Exception {
//        return mDbHelper.insertUser(user);
//    }
//
//    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
//        return mDbHelper.getUser(userId);
//    }
}
