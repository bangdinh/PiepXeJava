package com.xuanbang.me.piepxe.ui.main;

import com.xuanbang.me.piepxe.common.base.views.modules.BaseActivityModule;
import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;
import com.xuanbang.me.piepxe.ui.main.views.MainFragment;

import dagger.android.ContributesAndroidInjector;


@dagger.Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    @PerFragmentScoped
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment bindMainFragment();
}
