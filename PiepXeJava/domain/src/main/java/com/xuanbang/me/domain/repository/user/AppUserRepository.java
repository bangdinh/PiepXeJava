package com.xuanbang.me.domain.repository.user;

import android.util.Log;

import com.xuanbang.me.domain.entity.UserEntity;
import com.xuanbang.me.domain.mapper.user.UserDataMapper;
import com.xuanbang.me.flatform.IUserApi;
import com.xuanbang.me.flatform.db.DbProvider;
import com.xuanbang.me.flatform.remote.response.user.User;
import com.xuanbang.me.util.Checker;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public class AppUserRepository implements IAppUserRepository {

    private IUserApi mUserApi;
    private DbProvider mDbProvider;
    private UserDataMapper mDataMapper;

    @Inject
    public AppUserRepository(IUserApi userApi, DbProvider dbProvider, UserDataMapper dataMapper) {
        mUserApi = userApi;
        mDbProvider = dbProvider;
        mDataMapper = dataMapper;
    }

    /**
     * Using flatmap chuyển đổi thành observable khác
     * map thì chuyển đổi thành đối tượng khác
     */
    @Override
    public Flowable<UserEntity> getUser(final String usernId) {
        Log.e("AppUserRepository: ", "getUser ");

        return mDbProvider.userDao().getUser(usernId).flatMap((Function<User,
                Flowable<UserEntity>>) user -> {

            Log.e("AppUserRepository: ", "getUser 2222");
            if (Checker.isEmpty(user)) {
                return mUserApi.getUser(usernId).map(user1 -> {

                    mDbProvider.userDao().save(user1);

                    return mDataMapper.getUserEntityDataMapper().transform(user1);
                });
            }
            return Flowable.just(mDataMapper.getUserEntityDataMapper().transform(user));
        });

    }
//    @Override
//    public Flowable<UserEntity> getUser(final String usernId) {
//        Log.e("AppUserRepository: ", "getUser ");
//
//        return mUserApi.getUser(usernId).map(new Function<User, UserEntity>() {
//            @Override
//            public UserEntity apply(User user) throws Exception {
//                Log.e("AppUserRepository: ", "getUser 222222");
//                return mDataMapper.getUserEntityDataMapper().transform(user);
//            }
//        });
//    }
}
