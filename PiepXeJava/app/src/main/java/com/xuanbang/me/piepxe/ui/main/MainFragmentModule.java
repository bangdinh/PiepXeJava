package com.xuanbang.me.piepxe.ui.main;

import com.xuanbang.me.piepxe.common.base.views.modules.BaseFragmentModule;
import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;
import com.xuanbang.me.piepxe.ui.main.views.MainFragment;

import javax.inject.Named;

import androidx.fragment.app.Fragment;
import dagger.Binds;
import dagger.Module;

/**
 * Provides main fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class
})
public abstract class MainFragmentModule {


    /**
     * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
     * fragment modules, which must provide a concrete implementation of {@link Fragment}
     * and named {@link BaseFragmentModule#FRAGMENT}.
     *
     * @param fragment the main fragment
     * @return the fragment
     */
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragmentScoped
    @Binds
    abstract Fragment baseFragment(MainFragment fragment);
}
