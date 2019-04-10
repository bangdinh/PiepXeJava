package com.xuanbang.me.piepxe.common.base.views.modules;

import com.xuanbang.me.piepxe.common.base.views.core.BaseActivity;
import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule {

    public static final String ACTIVITY_FRAGMENT_MANAGER = "ACTIVITY_FRAGMENT_MANAGER";

    /**
     * PerActivity annotation isn't necessary since Activity instance is unique but is here for
     * convention. In general, providing Application, Activity, Fragment, BroadcastReceiver,
     * etc does not require scoped annotations since they are the components being injected and
     * their instance is unique.
     * <p>
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
//    @Provides
//    @PerActivityScoped
//    static Context activityContext(BaseActivity activity) {
//        return activity.getBaseContext();
//    }


    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @Provides
    @PerActivityScoped
    static androidx.fragment.app.FragmentManager provideFragmentManager(BaseActivity activity) {
        return activity.getSupportFragmentManager();
    }


}
