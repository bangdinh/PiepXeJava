package com.xuanbang.me.domain.di.module;

import com.xuanbang.me.domain.executor.AppSchedulerProvider;
import com.xuanbang.me.domain.executor.SchedulerProvider;
import com.xuanbang.me.domain.repository.user.AppUserRepository;
import com.xuanbang.me.domain.repository.user.IAppUserRepository;
import com.xuanbang.me.flatform.di.module.DbModule;
import com.xuanbang.me.flatform.di.module.NetModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = {DbModule.class, NetModule.class})
public abstract class DataModule {

    @Binds
    abstract IAppUserRepository provideAppUserRepository(AppUserRepository repository);

    @Binds
    abstract SchedulerProvider provideChedulerProvider(AppSchedulerProvider schedulerProvider);

}
