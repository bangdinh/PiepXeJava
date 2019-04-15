package com.xuanbang.me.piepxe.common.base.views.core;

import com.xuanbang.me.piepxe.R;
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
        fragmentManager.beginTransaction()
                .add(containerViewId, fragment).commit();
    }

    protected final void replaceFragment(@IdRes int containerViewId, @NonNull Fragment fragment) {
        fragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.abc_grow_fade_in_from_bottom,
                        R.anim.abc_fade_out,
                        R.anim.abc_fade_in,
                        R.anim.abc_shrink_fade_out_from_bottom)
                .replace(containerViewId, fragment)
                .addToBackStack(null).commit();
    }

    protected final void removeFragment(@NonNull Fragment fragment) {
        fragmentManager.beginTransaction().remove(fragment).commit();
    }
}
