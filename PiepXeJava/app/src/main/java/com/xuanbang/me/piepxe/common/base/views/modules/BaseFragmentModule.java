package com.xuanbang.me.piepxe.common.base.views.modules;

import com.xuanbang.me.piepxe.di.scopes.PerFragmentScoped;

import javax.inject.Named;

import androidx.fragment.app.Fragment;
import dagger.Module;
import dagger.Provides;

@Module
public class BaseFragmentModule {

    public static final String FRAGMENT = "BaseFragmentModule.fragment";
    public static final String CHILD_FRAGMENT_MANAGER = "BaseFragmentModule.childFragmentManager";

    @Provides
    @PerFragmentScoped
    @Named(CHILD_FRAGMENT_MANAGER)
    androidx.fragment.app.FragmentManager childFragmentManager(@Named(FRAGMENT) Fragment fragment) {
        return fragment.getChildFragmentManager();
    }
}
