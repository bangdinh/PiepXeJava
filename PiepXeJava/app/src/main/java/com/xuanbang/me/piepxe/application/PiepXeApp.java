package com.xuanbang.me.piepxe.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.xuanbang.me.piepxe.di.component.DaggerAppComponent;

import androidx.multidex.MultiDex;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


public class PiepXeApp extends DaggerApplication implements Application.ActivityLifecycleCallbacks {// implements HasActivityInjector, HasSupportFragmentInjector


//    @Inject
//    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

//    private AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
//
//    public  AppComponent getAppComponent() {
//        return appComponent;
//    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        this.injectDagger();
        registerActivityLifecycleCallbacks(this);
    }

//    private void injectDagger() {
//        appComponent.inject(this);
//    }

//    @Override
//    public AndroidInjector<Activity> activityInjector() {
//        return dispatchingAndroidInjector;
//    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
