package com.xuanbang.me.piepxe.ui.nulls;

import com.xuanbang.me.piepxe.common.base.views.core.BaseActivity;
import com.xuanbang.me.piepxe.common.base.views.modules.BaseActivityModule;
import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;
import com.xuanbang.me.piepxe.ui.nulls.views.NullMainActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseActivityModule.class)
public abstract class NullMainActivityModule {

    @PerActivityScoped
    @Provides
    static BaseActivity baseActivity(NullMainActivity activity) {
        return activity;
    }

//    @PerFragmentScoped
//    @ContributesAndroidInjector(modules = MainFragmentModule.class)
//    abstract MainFragment bindMainFragment();
}
