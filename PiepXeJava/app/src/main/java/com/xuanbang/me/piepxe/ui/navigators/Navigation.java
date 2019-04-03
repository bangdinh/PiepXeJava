package com.xuanbang.me.piepxe.ui.navigators;

import android.content.Intent;

import com.xuanbang.me.piepxe.ui.home.views.HomeActivity;

import javax.inject.Inject;

import androidx.fragment.app.FragmentActivity;

public final class Navigation {
    @Inject
    public Navigation() {
    }

    public void startActivityHome(FragmentActivity mainActivity, HomeActivity homeActivity) {
        Intent intent = new Intent(mainActivity, HomeActivity.class);
        mainActivity.startActivity(intent);
    }
}
