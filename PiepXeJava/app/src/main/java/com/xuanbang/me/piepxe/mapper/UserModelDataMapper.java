package com.xuanbang.me.piepxe.mapper;

import com.xuanbang.me.domain.entity.UserEntity;
import com.xuanbang.me.piepxe.model.UserModel;

import javax.inject.Inject;

public class UserModelDataMapper {

    @Inject
    public UserModelDataMapper() {
    }

    /**
     * Transform a {@link UserEntity} into an {@link UserModel}.
     *
     * @param userEntity Object to be transformed.
     * @return {@link UserModel}.
     */
    public UserModel transform(UserEntity userEntity) {
        if (userEntity == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final UserModel userModel = new UserModel();

        userModel.id = userEntity.id;
        userModel.login = userEntity.login;
        userModel.avatar_url = userEntity.avatar_url;
        userModel.name = userEntity.name;
        userModel.company = userEntity.company;
        userModel.blog = userEntity.blog;

        return userModel;
    }
}
