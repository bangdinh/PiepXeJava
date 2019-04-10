package com.xuanbang.me.piepxe.di.module;

import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;
import com.xuanbang.me.piepxe.ui.login.LoginAccountActivityModule;
import com.xuanbang.me.piepxe.ui.login.views.LoginAccountActivity;
import com.xuanbang.me.piepxe.ui.main.MainActivityModule;
import com.xuanbang.me.piepxe.ui.main.views.MainActivity;
import com.xuanbang.me.piepxe.ui.nulls.NullMainActivityModule;
import com.xuanbang.me.piepxe.ui.nulls.views.NullMainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @PerActivityScoped
    @ContributesAndroidInjector(modules = {NullMainActivityModule.class})
    abstract NullMainActivity bindNullMainActivity();

    @PerActivityScoped
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();

    @PerActivityScoped
    @ContributesAndroidInjector(modules = {LoginAccountActivityModule.class})
    abstract LoginAccountActivity bindLoginAccountActivity();
}
