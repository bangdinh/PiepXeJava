package com.xuanbang.me.piepxe.ui.main.views;

import android.os.Bundle;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.views.BaseFragmentMVVM;
import com.xuanbang.me.piepxe.common.base.views.modules.BaseFragmentModule;
import com.xuanbang.me.piepxe.databinding.MainFragmentBinding;
import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;
import com.xuanbang.me.piepxe.ui.home.views.HomeFragment;
import com.xuanbang.me.piepxe.ui.main.viewmodels.MainFragmentViewModel;
import com.xuanbang.me.piepxe.ui.navigators.Navigation;

import javax.inject.Inject;
import javax.inject.Named;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;

public class MainFragment extends BaseFragmentMVVM<MainFragmentBinding, MainFragmentViewModel> {

    private final static String TAG = MainFragment.class.getSimpleName();

    @Inject
    Navigation mNavigation;

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {

        mViewModel = ViewModelProviders.of(this, factory).get(MainFragmentViewModel.class);
        // mNavigation.startActivityHome(getActivity(), new HomeActivity());
    }


    @Override
    public void initData(Bundle saveInstanceState) {
        addChildFragment(R.id.frame_contain_child, new HomeFragment());
    }



    /**
     * Provides main fragment dependencies.
     */
    @dagger.Module(includes = {
            BaseFragmentModule.class
    })
    public abstract static class Module {


        /**
         * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
         * fragment modules, which must provide a concrete implementation of {@link Fragment}
         * and named {@link BaseFragmentModule#FRAGMENT}.
         *
         * @param fragment the main fragment
         * @return the fragment
         */
        @Named(BaseFragmentModule.FRAGMENT)
        @PerFragmentScoped
        @Binds
        abstract Fragment baseFragment(MainFragment fragment);

    }
}
