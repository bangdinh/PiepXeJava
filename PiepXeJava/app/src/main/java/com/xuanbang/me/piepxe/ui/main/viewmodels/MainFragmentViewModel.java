package com.xuanbang.me.piepxe.ui.main.viewmodels;

import android.app.Application;

import com.xuanbang.me.piepxe.common.base.views.BaseViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class MainFragmentViewModel extends BaseViewModel {

    @Inject
    public MainFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void detach() {

    }
}
