package com.xuanbang.me.domain.mapper.user;

import com.xuanbang.me.domain.entity.UserEntity;
import com.xuanbang.me.flatform.remote.response.user.User;

import javax.inject.Inject;

public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper() {
    }

    /**
     * Transform a {@link com.xuanbang.me.flatform.remote.response.user.User} into an {@link com.xuanbang.me.domain.entity.UserEntity}.
     *
     * @param user Object to be transformed.
     * @return {@link com.xuanbang.me.domain.entity.UserEntity}.
     */
    public UserEntity transform(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot transform a user null value");
        }
        final UserEntity userModel = new UserEntity();
        userModel.id = user.id;
        userModel.login = user.login;
        userModel.avatar_url = user.avatar_url;
        userModel.name = user.name;
        userModel.company = user.company;
        userModel.blog = user.blog;
//        userModel.lastRefresh = user.lastRefresh;

        return userModel;
    }
}
