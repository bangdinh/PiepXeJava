package com.xuanbang.me.piepxe.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.xuanbang.me.util.Constant.APP_CONTEXT;

@Module
public class AppModule {

    // expose Application as an injectable context
    @Singleton
    @Provides
    @Named(APP_CONTEXT)
    Context provideAppContext(Application application) {
        return application.getApplicationContext();
    }


}
