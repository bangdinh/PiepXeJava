package com.xuanbang.me.piepxe.common.base.views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuanbang.me.piepxe.common.base.views.core.BaseFragment;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

/**
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://mindorks.com/license/apache-v2
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
public abstract class BaseFragmentMVVM<T extends ViewDataBinding, V extends BaseViewModel> extends BaseFragment {


    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    protected T mViewDataBinding;
    protected V mViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mViewDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("BASE FM", savedInstanceState != null ? "TRUE" : "FALSE");
        initViewModel(mViewModelFactory);
        initData(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mViewDataBinding = null;
    }

    /**
     * @return layout resource id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * Data initialization
     *
     * @param saveInstanceState Bundle
     */
    public abstract void initData(Bundle saveInstanceState);

    public abstract void initViewModel(ViewModelProvider.Factory factory);
}
