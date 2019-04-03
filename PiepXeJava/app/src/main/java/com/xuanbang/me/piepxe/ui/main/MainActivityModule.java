package com.xuanbang.me.piepxe.ui.main;

import com.xuanbang.me.piepxe.common.base.views.core.BaseActivity;
import com.xuanbang.me.piepxe.common.base.views.modules.BaseActivityModule;
import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;
import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;
import com.xuanbang.me.piepxe.ui.main.views.MainActivity;
import com.xuanbang.me.piepxe.ui.main.views.MainFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    @PerActivityScoped
    @Binds
    abstract BaseActivity baseActivity(MainActivity activity);

    @PerFragmentScoped
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment bindMainFragment();
}
