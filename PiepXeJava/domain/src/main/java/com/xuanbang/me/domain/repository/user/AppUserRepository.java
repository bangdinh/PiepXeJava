package com.xuanbang.me.domain.repository.user;

import android.util.Log;

import com.xuanbang.me.domain.entity.UserEntity;
import com.xuanbang.me.domain.mapper.user.UserDataMapper;
import com.xuanbang.me.flatform.IUserApi;
import com.xuanbang.me.flatform.db.DbProvider;
import com.xuanbang.me.flatform.remote.response.user.User;
import com.xuanbang.me.util.Checker;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;


/**
 * Ref: https://viblo.asia/p/trainingrx-observable-va-flowable-LzD5dDxO5jY
 */
public class AppUserRepository implements IAppUserRepository {

    private IUserApi mUserApi;
    private DbProvider mDbProvider;
    private UserDataMapper mDataMapper;
    private UserEntity userCache;


    @Inject
    public AppUserRepository(IUserApi userApi, DbProvider dbProvider, UserDataMapper dataMapper) {
        this.mUserApi = userApi;
        this.mDbProvider = dbProvider;
        this.mDataMapper = dataMapper;
    }

    private Maybe<UserEntity> getUserMaybeFromCache() {
        if (userCache != null) {
            return Maybe.just(userCache);
        }
        return Maybe.empty();
    }


//    public Flowable<UserEntity> loginWithUserName(final String userId) {
//        return getUserMaybeFromCache().toFlowable().concatWith(mDbProvider.userDao().getUser(userId).flatMap((Function<List<User>, Flowable<UserEntity>>) users -> {
//            if (Checker.isEmpty(users)) {
//                return mUserApi.getUser(userId).map(user1 -> {
//                    mDbProvider.userDao().save(user1);
//                    return mDataMapper.getUserEntityDataMapper().transform(user1);
//                }).take(1).doOnNext(this::createUserSession);
//            }
//            return Flowable.just(mDataMapper.getUserEntityDataMapper().transform(users.get(0)));
//        }));
//    }

    /**
     * Using flatmap chuyển đổi thành observable khác
     * map thì chuyển đổi thành đối tượng khác
     */
    @Override
    public Flowable<UserEntity> getUser(final String usernId) {


        return mDbProvider.userDao().getUser(usernId).flatMap((Function<List<User>,
                Flowable<UserEntity>>) users -> {

            Log.e(">>>>> 1 ", users.get(0).toString());
            //check if user was fetched recently
            Date date = Checker.getMaxRefreshTime(new Date());

            User userFlowable = mDbProvider.userDao().hasUser(usernId, date);
            Log.e(">>>>> 2 ", userFlowable.toString());
//            boolean userExits = userFlowable != null;

            if (Checker.isEmpty(users)) {

                return mUserApi.getUser(usernId).map(user1 -> {

                    mDbProvider.userDao().save(user1);

                    return mDataMapper.getUserEntityDataMapper().transform(user1);
                });
            }
            return Flowable.just(mDataMapper.getUserEntityDataMapper().transform(users.get(0)));
        });
    }

    @Override
    public Flowable<UserEntity> getUser() {
        return mDbProvider.userDao().getUser().flatMap((Function<List<User>, Flowable<UserEntity>>) users ->
                Flowable.just(mDataMapper.getUserEntityDataMapper().transform(users.get(0))));
    }
}
