package com.xuanbang.me.piepxe.ui.main.views;

import android.os.Bundle;
import android.util.Log;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.navigation.Navigator;
import com.xuanbang.me.piepxe.common.base.views.BaseActivityMVVM;
import com.xuanbang.me.piepxe.databinding.ActivityMainBinding;
import com.xuanbang.me.piepxe.ui.main.viewmodels.MainActivityViewModel;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends BaseActivityMVVM<ActivityMainBinding, MainActivityViewModel> {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Inject
    Navigator mNavigator;

    @Override
    public int getLayoutId() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainActivityViewModel.class);
        return R.layout.activity_main;
    }


    @Override
    public void initData(Bundle savedInstanceState) {
//        mNavigator.doSomeThing(this);
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_contain);
        if (savedInstanceState == null && mainFragment == null) {
            addFragment(R.id.frame_contain, new MainFragment());
        }
        mViewModel.getResults("bangdinh").observe(this, userModelResource -> {
            if (userModelResource != null && userModelResource.data != null) {
                Log.e(TAG, userModelResource.data.toString());
            } else {
                Log.e(TAG, "Null");
            }

        });
    }

    @Override
    protected void detach() {
        mViewModel.detach();
    }
}
