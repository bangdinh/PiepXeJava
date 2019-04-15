package com.xuanbang.me.piepxe.ui.login;

import android.view.View;

public interface PresenterLogin {
    void login(View view);

    void register(View view);

    void loginWithFacebook(View view);

    void loginWithGoogle(View view);
}
