package com.xuanbang.me.piepxe.di.module;

import android.app.Application;

import com.bumptech.glide.RequestManager;
import com.xuanbang.me.piepxe.GlideApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppDataBindingModule {
    @Provides
    @Singleton
    static RequestManager provideRequestManager(Application application) {
        return GlideApp.with(application);
    }
}
