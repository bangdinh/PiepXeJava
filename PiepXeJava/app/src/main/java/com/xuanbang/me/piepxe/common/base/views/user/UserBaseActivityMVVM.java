package com.xuanbang.me.piepxe.common.base.views.user;

import android.os.Bundle;
import android.util.Log;

import com.xuanbang.me.piepxe.common.base.views.BaseViewModel;
import com.xuanbang.me.piepxe.common.base.views.core.BaseActivity;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

public abstract class UserBaseActivityMVVM<T extends ViewDataBinding, V extends BaseViewModel> extends BaseActivity {
    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();


    @Inject
    protected ViewModelProvider.Factory mViewModelFactory;

    protected T mViewDataBinding;
    protected V mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.initData(savedInstanceState);
    }

    /**
     * Data initialization
     *
     * @param savedInstanceState Bundle
     */
    public abstract void initData(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy: ", "onDestroy");
        this.mViewDataBinding = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause: ", "onPause");
    }
}
