package com.xuanbang.me.piepxe.di.component;

import android.app.Application;

import com.xuanbang.me.domain.di.module.AndroidModule;
import com.xuanbang.me.domain.di.module.DataModule;
import com.xuanbang.me.piepxe.application.PiepXeApp;
import com.xuanbang.me.piepxe.di.module.ActivityBindingModule;
import com.xuanbang.me.piepxe.di.module.ActivityModule;
import com.xuanbang.me.piepxe.di.module.AppModule;
import com.xuanbang.me.piepxe.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

//@ApplicationScoped
@Singleton
@dagger.Component(modules = {
        AppModule.class,
        ActivityModule.class,
        AndroidModule.class,
        ActivityBindingModule.class,
        ViewModelModule.class,
        DataModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<PiepXeApp> {
    /**
     * The root component's builder.
     */

    @dagger.Component.Builder
    interface Buidler {
        @BindsInstance
        AppComponent.Buidler application(Application app);

        AppComponent build();
    }
}
