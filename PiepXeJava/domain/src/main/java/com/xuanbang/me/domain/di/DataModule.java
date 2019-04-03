package com.xuanbang.me.domain.di;

import com.xuanbang.me.domain.executor.AppSchedulerProvider;
import com.xuanbang.me.domain.executor.SchedulerProvider;
import com.xuanbang.me.domain.repository.user.AppUserRepository;
import com.xuanbang.me.domain.repository.user.IAppUserRepository;
import com.xuanbang.me.flatform.di.module.DbModule;
import com.xuanbang.me.flatform.di.module.NetModule;

import dagger.Module;
import dagger.Provides;

@Module(includes = {DbModule.class, NetModule.class})
public class DataModule {

    @Provides
    IAppUserRepository provideAppUserRepository(AppUserRepository repository) {
        return repository;
    }


    @Provides
    SchedulerProvider provideChedulerProvider(AppSchedulerProvider schedulerProvider) {
        return schedulerProvider;
    }


}
