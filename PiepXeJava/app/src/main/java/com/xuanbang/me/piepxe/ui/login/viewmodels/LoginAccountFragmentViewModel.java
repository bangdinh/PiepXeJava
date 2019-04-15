package com.xuanbang.me.piepxe.ui.login.viewmodels;

import android.app.Application;

import com.xuanbang.me.piepxe.common.base.views.BaseViewModel;
import com.xuanbang.me.piepxe.model.UserModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class LoginAccountFragmentViewModel extends BaseViewModel {


    private MutableLiveData<UserModel> mUserModelMutableLiveData;
    public UserModel mUserModel;

    @Inject
    public LoginAccountFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public void initViewModel() {
        if (mUserModel == null) {
            mUserModel = new UserModel();
        }
    }

}
