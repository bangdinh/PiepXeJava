package com.xuanbang.me.piepxe.ui.main.views;

import android.os.Bundle;
import android.util.Log;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.navigation.Navigator;
import com.xuanbang.me.piepxe.common.base.views.BaseActivityMVVM;
import com.xuanbang.me.piepxe.common.base.views.core.BaseActivity;
import com.xuanbang.me.piepxe.common.base.views.modules.BaseActivityModule;
import com.xuanbang.me.piepxe.databinding.ActivityMainBinding;
import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;
import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;
import com.xuanbang.me.piepxe.ui.main.viewmodels.MainActivityViewModel;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.android.ContributesAndroidInjector;

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
        setupWindowAnimations();
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_contain);
        if (savedInstanceState == null && mainFragment == null) {
            addFragment(R.id.frame_contain, new MainFragment());
        }
//        mViewModel.getResults("bangdinh").observe(this, userModelResource -> {
//
//            if (userModelResource != null && userModelResource.data != null) {
//                Log.e(TAG, userModelResource.toString());
//            }
//
//        });
    }

    private void setupWindowAnimations() {
//        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
//        getWindow().setExitTransition(fade);
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed() " + isTaskRoot());
        if (isTaskRoot()) {
            //Sending Activity runing background using Intent startMain = new Intent(Intent.ACTION_MAIN);
            //startMain.addCategory(Intent.CATEGORY_HOME);
            //startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //startActivity(startMain);
            //or
            moveTaskToBack(true);

        } else {
            super.onBackPressed();
        }


    }


    @dagger.Module(includes = BaseActivityModule.class)
    public abstract static class Module {

        @Binds
        @PerActivityScoped
        abstract BaseActivity bindBaseActivity(MainActivity activity);

        @PerFragmentScoped
        @ContributesAndroidInjector(modules = MainFragment.Module.class)
        abstract MainFragment bindMainFragment();
    }
}
