package com.xuanbang.me.piepxe.ui.login.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.views.BaseActivityMVVM;
import com.xuanbang.me.piepxe.common.base.views.modules.BaseActivityModule;
import com.xuanbang.me.piepxe.databinding.ActivityLoginAccountBinding;
import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;
import com.xuanbang.me.piepxe.ui.login.PresenterLogin;
import com.xuanbang.me.piepxe.ui.login.viewmodels.LoginAccountActivityViewModel;
import com.xuanbang.me.piepxe.ui.main.views.MainActivity;

import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.ContributesAndroidInjector;

public class LoginAccountActivity extends BaseActivityMVVM<ActivityLoginAccountBinding, LoginAccountActivityViewModel> implements PresenterLogin {

    private static final String TAG = LoginAccountActivity.class.getSimpleName();

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_account;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(LoginAccountActivityViewModel.class);
        mViewDataBinding.setViewmodel(mViewModel);
        mViewDataBinding.setPresenterLogin(this);

        Fragment fragment = fragmentManager.findFragmentById(R.id.frame_contain);
        if (savedInstanceState == null && fragment == null) {
            LoginAccountFragment accountFragment = new LoginAccountFragment();
            addFragment(R.id.frame_contain, accountFragment);
        }

    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed() " + isTaskRoot());
        super.onBackPressed();
//        if (isTaskRoot()) {
//            moveTaskToBack(true);
//        } else {
//            super.onBackPressed();
//        }
    }

    public void loginWitAccount() {
        Intent intent = new Intent(LoginAccountActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out);
        startActivity(intent, optionsCompat.toBundle());
        finish();
    }


    @Override
    public void login(View view) {
//        login();
        Log.e(TAG, "Click");
    }

    @Override
    public void register(View view) {
        Log.e(TAG, "Click register");
        RegisterAccountFragment accountFragment = new RegisterAccountFragment();
        replaceFragment(R.id.frame_contain, accountFragment);
    }

    @Override
    public void loginWithFacebook(View view) {
        Log.e(TAG, "Click loginWithFacebook");
    }

    @Override
    public void loginWithGoogle(View view) {
        Log.e(TAG, "Click loginWithGoogle");
    }


    @dagger.Module(includes = BaseActivityModule.class)
    public abstract static class Module {

        @PerFragmentScoped
        @ContributesAndroidInjector(modules = {LoginAccountFragment.Module.class})
        abstract LoginAccountFragment loginAccountFragment();

        @PerFragmentScoped
        @ContributesAndroidInjector(modules = {RegisterAccountFragment.Module.class})
        abstract RegisterAccountFragment registerAccountFragment();
    }
}
