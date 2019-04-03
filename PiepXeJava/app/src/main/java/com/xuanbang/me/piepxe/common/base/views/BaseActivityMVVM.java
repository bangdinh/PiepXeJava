package com.xuanbang.me.piepxe.common.base.views;

import android.os.Bundle;

import com.xuanbang.me.piepxe.common.base.views.core.BaseActivity;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import butterknife.ButterKnife;

public abstract class BaseActivityMVVM<T extends ViewDataBinding, V extends BaseViewModel> extends BaseActivity {

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
        ButterKnife.bind(this);
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
        this.mViewDataBinding = null;
        this.mViewModel = null;
    }
}
