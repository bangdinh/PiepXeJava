package com.xuanbang.me.piepxe.ui.login.views;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.views.BaseFragmentMVVM;
import com.xuanbang.me.piepxe.common.base.views.modules.BaseFragmentModule;
import com.xuanbang.me.piepxe.databinding.LoginAccountFragmentBinding;
import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;
import com.xuanbang.me.piepxe.ui.login.PresenterLogin;
import com.xuanbang.me.piepxe.ui.login.viewmodels.LoginAccountFragmentViewModel;

import javax.inject.Named;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStore;
import dagger.Binds;

public class LoginAccountFragment extends BaseFragmentMVVM<LoginAccountFragmentBinding, LoginAccountFragmentViewModel> {

    private final static String TAG = LoginAccountFragment.class.getSimpleName();
    private PresenterLogin mPresenterLogin;

    public LoginAccountFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate()");
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return super.getViewModelStore();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");
    }


    @Override
    protected int getLayoutId() {
        return R.layout.login_account_fragment;
    }

    @Override
    public void initData(Bundle saveInstanceState) {
        Log.e(TAG, "OncreateView() ");
        mViewModel.initViewModel();
        mViewDataBinding.setLoginViewModel(mViewModel);
        mViewDataBinding.setPresenterLogin(mPresenterLogin);
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(this, factory).get(LoginAccountFragmentViewModel.class);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach()");
        try {
            mPresenterLogin = (PresenterLogin) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement PresenterLogin");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }

    @dagger.Module(includes = {BaseFragmentModule.class})
    public abstract static class Module {

        @Named(BaseFragmentModule.FRAGMENT)
        @PerFragmentScoped
        @Binds
        abstract Fragment baseFragment(LoginAccountFragment fragment);

    }
}
