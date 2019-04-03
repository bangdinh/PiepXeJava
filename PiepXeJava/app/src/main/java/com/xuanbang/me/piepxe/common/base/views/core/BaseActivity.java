package com.xuanbang.me.piepxe.common.base.views.core;

import com.xuanbang.me.piepxe.common.base.views.modules.BaseActivityModule;

import javax.inject.Inject;
import javax.inject.Named;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
    @Inject
    protected FragmentManager fragmentManager;


    protected final void addFragment(@IdRes int containerViewId, @NonNull Fragment fragment) {
        fragmentManager.beginTransaction().add(containerViewId, fragment).commitNowAllowingStateLoss();
    }

    protected final void replaceFragment(FragmentManager fragmentManager, @IdRes int containerViewId, @NonNull Fragment fragment) {
        fragmentManager.beginTransaction().replace(containerViewId, fragment).commitNowAllowingStateLoss();
    }

    protected final void removeFragment(FragmentManager fragmentManager, @NonNull Fragment fragment) {
        fragmentManager.beginTransaction().remove(fragment).commit();
    }

    protected abstract void detach();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detach();
    }
}
