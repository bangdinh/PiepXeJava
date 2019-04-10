package com.xuanbang.me.piepxe.ui.login;

import com.xuanbang.me.piepxe.common.base.views.core.BaseActivity;
import com.xuanbang.me.piepxe.common.base.views.modules.BaseActivityModule;
import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;
import com.xuanbang.me.piepxe.ui.login.views.LoginAccountActivity;

import dagger.Binds;
import dagger.Module;

@Module(includes = BaseActivityModule.class)
public abstract class LoginAccountActivityModule {
    @PerActivityScoped
    @Binds
    abstract BaseActivity baseActivity(LoginAccountActivity activity);

}
