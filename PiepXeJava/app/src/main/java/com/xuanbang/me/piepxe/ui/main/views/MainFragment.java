package com.xuanbang.me.piepxe.ui.main.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.views.BaseFragmentMVVM;
import com.xuanbang.me.piepxe.databinding.MainFragmentBinding;
import com.xuanbang.me.piepxe.ui.home.views.HomeActivity;
import com.xuanbang.me.piepxe.ui.home.views.HomeFragment;
import com.xuanbang.me.piepxe.ui.main.viewmodels.MainFragmentViewModel;
import com.xuanbang.me.piepxe.ui.navigators.Navigation;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;

public class MainFragment extends BaseFragmentMVVM<MainFragmentBinding, MainFragmentViewModel> {

    private final static String TAG = MainFragment.class.getSimpleName();
    @BindView(R.id.frame_contain_child)
    FrameLayout frame_contain_child;
    @BindView(R.id.btn_home_activity)
    Button btn_home_activity;

    @Inject
    Navigation mNavigation;

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {

        mViewModel = ViewModelProviders.of(this, factory).get(MainFragmentViewModel.class);
    }


    @Override
    public void initData(Bundle saveInstanceState) {
        addChildFragment(R.id.frame_contain_child, new HomeFragment());
    }


    @Override
    protected void detach() {
        mViewModel.detach();
    }


    @OnClick({R.id.btn_home_activity, R.id.frame_contain_child})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_home_activity:
                mNavigation.startActivityHome(getActivity(), new HomeActivity());
                break;
            case R.id.frame_contain_child:
                break;
        }
    }
}
