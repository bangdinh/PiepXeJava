package com.xuanbang.me.domain.interactor;

import com.xuanbang.me.domain.entity.UserEntity;
import com.xuanbang.me.domain.executor.SchedulerProvider;
import com.xuanbang.me.domain.interactor.core.UseCase;
import com.xuanbang.me.domain.repository.user.IAppUserRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class GetUserUseCase extends UseCase<UserEntity, String> {

    @Inject
    public GetUserUseCase(IAppUserRepository iAppUserRepository, SchedulerProvider schedulerProvider) {
        super(iAppUserRepository, schedulerProvider);
    }


    @Override
    protected Flowable<UserEntity> buildUseCaseFlowable(String s) {
        return iAppRepository.getUser(s);
    }

    @Override
    protected Observable<UserEntity> buildUseCaseObserve(String s) {
        return null;
    }

    @Override
    protected Single<String> buildUserCaseSingle() {
        return iAppRepository.getIdUserSharedPrefs();
    }


}
