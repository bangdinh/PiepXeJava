package com.xuanbang.me.piepxe.di.module;

import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;
import com.xuanbang.me.piepxe.ui.main.MainActivityModule;
import com.xuanbang.me.piepxe.ui.main.views.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

//@Module(subcomponents = {
//        UserComponent.class
//})
@Module
public abstract class ActivityBindingModule {

//    @PerActivityScoped
//    @ContributesAndroidInjector(modules = {NullMainActivityModule.class})
//    abstract NullMainActivity bindNullMainActivity();

    @PerActivityScoped
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();
}
