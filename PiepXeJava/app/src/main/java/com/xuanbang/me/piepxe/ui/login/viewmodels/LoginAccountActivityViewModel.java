package com.xuanbang.me.piepxe.ui.login.viewmodels;

import android.app.Application;
import android.content.Intent;
import android.view.View;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.views.BaseViewModel;
import com.xuanbang.me.piepxe.ui.main.views.MainActivity;
import com.xuanbang.me.piepxe.ui.nulls.views.NullMainActivity;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class LoginAccountActivityViewModel extends BaseViewModel {
    @Inject
    public LoginAccountActivityViewModel(@NonNull Application application) {
        super(application);
    }

    private void login(View view) {

    }
}
