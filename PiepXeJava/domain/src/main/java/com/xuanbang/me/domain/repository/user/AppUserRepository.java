package com.xuanbang.me.domain.repository.user;

import android.util.Log;

import com.xuanbang.me.domain.entity.UserEntity;
import com.xuanbang.me.domain.helper.SharedPrefsHelper;
import com.xuanbang.me.domain.mapper.user.UserDataMapper;
import com.xuanbang.me.flatform.IUserApi;
import com.xuanbang.me.flatform.db.DbProvider;
import com.xuanbang.me.flatform.remote.response.user.User;
import com.xuanbang.me.util.Checker;
import com.xuanbang.me.util.Constant;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Function;


/**
 * Ref: https://viblo.asia/p/trainingrx-observable-va-flowable-LzD5dDxO5jY
 */
public class AppUserRepository implements IAppUserRepository {


    private IUserApi mUserApi;
    private DbProvider mDbProvider;
    private UserDataMapper mDataMapper;
    private UserEntity userCache;
    private SharedPrefsHelper mPrefsHelperUser;


    @Inject
    public AppUserRepository(IUserApi userApi, DbProvider dbProvider, UserDataMapper dataMapper, SharedPrefsHelper prefsHelperUser) {
        this.mUserApi = userApi;
        this.mDbProvider = dbProvider;
        this.mDataMapper = dataMapper;
        this.mPrefsHelperUser = prefsHelperUser;
    }

    private Maybe<UserEntity> getUserMaybeFromCache() {
        if (userCache != null) {
            return Maybe.just(userCache);
        }
        return Maybe.empty();
    }

    /**
     * Using flatmap chuyển đổi thành observable khác
     * map thì chuyển đổi thành đối tượng khác
     */
    @Override
    public Flowable<UserEntity> getUser(final String usernId) {


        return mDbProvider.userDao().getUser(usernId).flatMap((Function<List<User>,
                Flowable<UserEntity>>) users -> {

            /**
             * Khi chưa có user nào thì chạy hàm login
             * */
            if (Checker.isEmpty(users)) {


                Log.e(">>>>> 1 ", users.get(0).toString());
                //check if user was fetched recently
                Date date = Checker.getMaxRefreshTime(new Date());

                User userFlowable = mDbProvider.userDao().hasUser(usernId, date);
                Log.e(">>>>> 2 ", userFlowable.toString());
//            boolean userExits = userFlowable != null;


                return mUserApi.getUser(usernId).map(user1 -> {

                    //save user sqlite
                    mDbProvider.userDao().save(user1);
                    //save userId
                    mPrefsHelperUser.put(SharedPrefsHelper.PREF_KEY_USER, usernId);

                    return mDataMapper.getUserEntityDataMapper().transform(user1);
                });
            }
            return Flowable.just(mDataMapper.getUserEntityDataMapper().transform(users.get(0)));
        });
    }


    /**
     * Hàm này chạy lúc mở app.
     * Check trạng thái của user có login chưa.
     * Có thì trả về thông tin user. => Chạy vào main
     * Chưa có thì trả về null => mở màn hình login
     */
    @Override
    public Flowable<UserEntity> getUser() {

        return mDbProvider.userDao().getUser().delay(Constant.TIME_DELAY_LOGIN, TimeUnit.MILLISECONDS).flatMap((Function<List<User>, Flowable<UserEntity>>) users -> {

            if (Checker.isEmpty(users)) {

                return Flowable.just(new UserEntity());
            }
            User user = users.get(0);
            UserEntity userEntity = new UserEntity();
            userEntity.login = "";
            return Flowable.just(userEntity);
//            return Flowable.just(mDataMapper.getUserEntityDataMapper().transform(user));
        });
    }

    @Override
    public Single<String> getIdUserSharedPrefs() {
        final String userId = mPrefsHelperUser.get(SharedPrefsHelper.PREF_KEY_USER, "");
        return Single.just(userId);
    }


//            //check if user was fetched recently
//            Date date = Checker.getMaxRefreshTime(new Date());
//            User user = users.get(0);
//
//            Log.e(">>>>xxx ", user.toString());
//            Log.e(">>>>Date ", date.toString());
//            Log.e(">>>>Date 2 ", date.getTime() + " -- " + user.lastRefresh.getTime());
//            Log.e(">>>>Date 3 ", date.getTime() >= user.lastRefresh.getTime() ? "TRUE" : "FALSE");
//
//            boolean hasUser = mDbProvider.userDao().hasUser(date) != null;
//
//            Log.e(">>>>Has ", hasUser + "");
}
