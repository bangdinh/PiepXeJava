package com.xuanbang.me.piepxe.ui.login.views;

import android.os.Bundle;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.views.BaseFragmentMVVM;
import com.xuanbang.me.piepxe.common.base.views.modules.BaseFragmentModule;
import com.xuanbang.me.piepxe.databinding.RegisterAccountFragmentBinding;
import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;
import com.xuanbang.me.piepxe.ui.login.viewmodels.LoginAccountFragmentViewModel;

import javax.inject.Named;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;

public class RegisterAccountFragment extends BaseFragmentMVVM<RegisterAccountFragmentBinding, LoginAccountFragmentViewModel> {
    @Override
    protected int getLayoutId() {
        return R.layout.register_account_fragment;
    }

    @Override
    public void initData(Bundle saveInstanceState) {

        setupToolbar();
    }

    private void setupToolbar() {
        activity.setSupportActionBar(mViewDataBinding.toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setTitle(getString(R.string.login_register));
        mViewDataBinding.toolbar.setNavigationOnClickListener(v -> activity.onBackPressed());
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(this, factory).get(LoginAccountFragmentViewModel.class);
    }


    @dagger.Module(includes = BaseFragmentModule.class)
    public abstract static class Module {
        @Named(BaseFragmentModule.FRAGMENT)
        @PerFragmentScoped
        @Binds
        abstract Fragment baseFragment(RegisterAccountFragment fragment);
    }
}
