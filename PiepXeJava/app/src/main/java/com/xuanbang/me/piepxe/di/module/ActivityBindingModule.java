package com.xuanbang.me.piepxe.di.module;

import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;
import com.xuanbang.me.piepxe.ui.login.views.LoginAccountActivity;
import com.xuanbang.me.piepxe.ui.main.MainActivityModule;
import com.xuanbang.me.piepxe.ui.main.views.MainActivity;
import com.xuanbang.me.piepxe.ui.started.views.NullMainActivity;

import dagger.android.ContributesAndroidInjector;

@dagger.Module
public abstract class ActivityBindingModule {

    @PerActivityScoped
    @ContributesAndroidInjector(modules = {NullMainActivity.Module.class})
    abstract NullMainActivity bindNullMainActivity();

    @PerActivityScoped
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();

    @PerActivityScoped
    @ContributesAndroidInjector(modules = {LoginAccountActivity.Module.class})
    abstract LoginAccountActivity bindLoginAccountActivity();
}
