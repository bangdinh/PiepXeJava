package com.xuanbang.me.piepxe.ui.started.views;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.Status;
import com.xuanbang.me.piepxe.common.base.views.BaseActivityMVVM;
import com.xuanbang.me.piepxe.common.base.views.core.BaseActivity;
import com.xuanbang.me.piepxe.common.base.views.modules.BaseActivityModule;
import com.xuanbang.me.piepxe.databinding.ActivityNullMainBinding;
import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;
import com.xuanbang.me.piepxe.model.UserModel;
import com.xuanbang.me.piepxe.ui.login.views.LoginAccountActivity;
import com.xuanbang.me.piepxe.ui.main.views.MainActivity;
import com.xuanbang.me.piepxe.ui.started.viewmodels.NullMainActivityViewModel;
import com.xuanbang.me.util.Checker;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;

public class NullMainActivity extends BaseActivityMVVM<ActivityNullMainBinding, NullMainActivityViewModel> {

    final static String TAG = NullMainActivity.class.getSimpleName();

    @Override
    public int getLayoutId() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(NullMainActivityViewModel.class);
        return R.layout.activity_null_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        mViewDataBinding.setViewmodelNull(mViewModel);

        configureScreenFetchData();
//        mViewModel.getResourceLiveData().observe(this, stringResource -> {
//
//                    Log.e(TAG, "getResourceLiveData --- " + stringResource);
//                }
//        );

    }

    private void configureScreenFetchData() {
        mViewModel.getResultsUser().observe(this, userModelResource -> {

            Log.e(TAG, userModelResource.toString());
            mViewDataBinding.setResource(userModelResource);
            mViewDataBinding.executePendingBindings();

            Status status = userModelResource.status;
            UserModel userModel = userModelResource.data;

            if (status.equals(Status.SUCCESS) && !Checker.isEmpty(userModel)) {
                Intent intent;
                if (userModel.login.equals("")) {
                    intent = new Intent(NullMainActivity.this, LoginAccountActivity.class);
                } else {
                    intent = new Intent(NullMainActivity.this, MainActivity.class);
                }
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out);
                startActivity(intent, options.toBundle());
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "---- " + requestCode);
        if (requestCode == 100) {
            mViewModel.detach();
            finish();
        } else if (requestCode == 101) {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed() " + isTaskRoot());

//        moveTaskToBack(true);
        super.onBackPressed();
    }

    @dagger.Module(includes = BaseActivityModule.class)
    public abstract static class Module {

        @Binds
        @PerActivityScoped
        abstract BaseActivity bindBaseActivity(NullMainActivity activity);
    }
}
