package com.xuanbang.me.domain.mapper.user;

import javax.inject.Inject;


/**
 * Mapper class used to transform {@link com.xuanbang.me.flatform.remote.response.user.User} (in the domain layer)
 * to {@link com.xuanbang.me.domain.entity.UserEntity} in the
 * presentation layer.
 */
public class UserDataMapper {
    private UserEntityDataMapper mUserEntityDataMapper;

    @Inject
    public UserDataMapper(UserEntityDataMapper userEntityDataMapper) {
        mUserEntityDataMapper = userEntityDataMapper;
    }

    public UserEntityDataMapper getUserEntityDataMapper() {
        return mUserEntityDataMapper;
    }
}
