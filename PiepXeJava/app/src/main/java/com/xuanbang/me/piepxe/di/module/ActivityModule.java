package com.xuanbang.me.piepxe.di.module;

import android.content.Context;

import com.xuanbang.me.piepxe.di.scopes.PerActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    @Provides
    @PerActivityScoped
    Context provideActivityContext(Context context) {
        return context;
    }
}
