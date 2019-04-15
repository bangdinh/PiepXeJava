package com.xuanbang.me.domain.interactor;

import com.xuanbang.me.domain.entity.UserEntity;
import com.xuanbang.me.domain.executor.SchedulerProvider;
import com.xuanbang.me.domain.interactor.core.UseCase;
import com.xuanbang.me.domain.repository.user.IAppUserRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class GetUserCore extends UseCase<UserEntity, Void> {

    @Inject
    public GetUserCore(IAppUserRepository iAppRepository, SchedulerProvider schedulerProvider) {
        super(iAppRepository, schedulerProvider);
    }

    @Override
    protected Flowable<UserEntity> buildUseCaseFlowable(Void aVoid) {
        return iAppRepository.getUser();
    }


    @Override
    protected Observable<UserEntity> buildUseCaseObserve(Void aVoid) {
        return null;
    }

    protected Single<String> buildUserCaseSingle() {
        return iAppRepository.getIdUserSharedPrefs();
    }
}
