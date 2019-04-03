package com.xuanbang.me.piepxe.ui.nulls;

import com.xuanbang.me.piepxe.common.base.views.modules.BaseActivityModule;
import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;
import com.xuanbang.me.piepxe.ui.main.MainFragmentModule;
import com.xuanbang.me.piepxe.ui.main.views.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class NullMainActivityModule {

//    @PerActivityScoped
//    @Provides
//    static BaseActivity baseActivity(NullMainActivity activity) {
//        return activity;
//    }

    @PerFragmentScoped
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment bindMainFragment();
}
