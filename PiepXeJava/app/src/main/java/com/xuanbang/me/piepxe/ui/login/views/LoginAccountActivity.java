package com.xuanbang.me.piepxe.ui.login.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.views.BaseActivityMVVM;
import com.xuanbang.me.piepxe.databinding.ActivityLoginAccountBinding;
import com.xuanbang.me.piepxe.ui.login.Presenter;
import com.xuanbang.me.piepxe.ui.login.viewmodels.LoginAccountActivityViewModel;
import com.xuanbang.me.piepxe.ui.main.views.MainActivity;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class LoginAccountActivity extends BaseActivityMVVM<ActivityLoginAccountBinding, LoginAccountActivityViewModel> implements Presenter {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_account;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(LoginAccountActivityViewModel.class);
        mViewDataBinding.setViewmodel(mViewModel);
        mViewDataBinding.setPresenter(this);
    }

    @Override
    public void onBackPressed() {
        if (isTaskRoot()) {
            moveTaskToBack(true);
        } else {
            super.onBackPressed();
        }
    }

    public void login() {
        Intent intent = new Intent(LoginAccountActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivityForResult(intent, 100);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            finish();
        }
    }

    @Override
    public void login(View view) {
        login();
    }
}
