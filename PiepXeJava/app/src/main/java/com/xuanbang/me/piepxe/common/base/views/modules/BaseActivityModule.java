package com.xuanbang.me.piepxe.common.base.views.modules;

import com.xuanbang.me.piepxe.common.base.views.core.BaseActivity;
import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;

import javax.inject.Named;

import dagger.Provides;

@dagger.Module
public abstract class BaseActivityModule {

    public static final String ACTIVITY_FRAGMENT_MANAGER = "ACTIVITY_FRAGMENT_MANAGER";


    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @Provides
    @PerActivityScoped
    static androidx.fragment.app.FragmentManager provideFragmentManager(BaseActivity activity) {
        return activity.getSupportFragmentManager();
    }


}
