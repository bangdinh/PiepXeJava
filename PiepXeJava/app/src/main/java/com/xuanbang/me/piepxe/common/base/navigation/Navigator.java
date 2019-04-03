package com.xuanbang.me.piepxe.common.base.navigation;


import android.content.Context;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import static com.xuanbang.me.util.Constant.APP_CONTEXT;

public final class Navigator {

    @Inject
    public Navigator() {
    }

    public void doSomeThing(@Named(APP_CONTEXT) Context context) {
        Log.e(">>>> NAvigation: ", context.getPackageName() + " ?????");
    }
//    public void addFragment(FragmentManager supportFragmentManager, @IdRes int containerViewId, Fragment fragment) {
//        supportFragmentManager.beginTransaction().add(containerViewId, fragment).commitNowAllowingStateLoss();
//    }
//
//    public final void replaceFragment(FragmentManager supportFragmentManager, @IdRes int containerViewId, @NonNull Fragment fragment) {
//        supportFragmentManager.beginTransaction().replace(containerViewId, fragment).commitNowAllowingStateLoss();
//    }
//
//    public final void removeFragment(FragmentManager supportFragmentManager, @NonNull Fragment fragment) {
//        supportFragmentManager.beginTransaction().remove(fragment).commit();
//    }
}
