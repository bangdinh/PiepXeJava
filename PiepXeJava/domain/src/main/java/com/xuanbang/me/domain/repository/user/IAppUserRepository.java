package com.xuanbang.me.domain.repository.user;

import com.xuanbang.me.domain.entity.UserEntity;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface IAppUserRepository {
    Flowable<UserEntity> getUser(String usernId);
    Flowable<UserEntity> getUser();
    Single<String> getIdUserSharedPrefs();
}
