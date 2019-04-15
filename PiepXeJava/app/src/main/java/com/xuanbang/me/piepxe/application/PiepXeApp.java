package com.xuanbang.me.piepxe.application;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.xuanbang.me.piepxe.di.component.DaggerAppComponent;
import com.xuanbang.me.piepxe.di.component.DaggerAppDataBindingComponent;

import java.util.List;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import androidx.multidex.MultiDex;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


public class PiepXeApp extends DaggerApplication implements Application.ActivityLifecycleCallbacks {// implements HasActivityInjector, HasSupportFragmentInjector


    @Inject
    ActivityManager manager;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(buildDataBindingComponent());
        registerActivityLifecycleCallbacks(this);
    }

    private androidx.databinding.DataBindingComponent buildDataBindingComponent() {
        return DaggerAppDataBindingComponent.builder().application(this).build();
    }

    public int getCurrentTaskId() {
        List<ActivityManager.RunningTaskInfo> runningTasks = manager.getRunningTasks(1);
        Log.e("ABC", "Size: " + runningTasks.size());

        ActivityManager.RunningTaskInfo runningTask = runningTasks.get(0);
        Log.e("ABC", "Size: " + runningTask.baseActivity.getPackageName());
        return runningTask.id;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }


    public static synchronized PiepXeApp get(Context context) {
        return (PiepXeApp) context.getApplicationContext();
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
