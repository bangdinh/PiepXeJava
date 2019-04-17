package com.xuanbang.me.piepxe.ui.login.viewmodels;

import android.app.Application;

import com.xuanbang.me.piepxe.common.base.views.BaseViewModel;
import com.xuanbang.me.piepxe.model.UserModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginAccountFragmentViewModel extends BaseViewModel {


    public MutableLiveData<String> mail;
    public UserModel mUserModel;

    @Inject
    public LoginAccountFragmentViewModel(@NonNull Application application) {
        super(application);
    }


    public void initViewModel() {
        if (mail == null) {
            mail = new MutableLiveData<>();
        }
    }


    public void setMail(String mail) {
        this.mail.setValue(mail);
    }

    public LiveData<String> getMail() {
        if (this.mail == null) {
            this.mail = new MutableLiveData<>();
        }
        return this.mail;
    }

}
