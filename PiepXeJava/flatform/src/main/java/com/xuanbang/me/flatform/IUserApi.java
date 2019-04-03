package com.xuanbang.me.flatform;

import com.xuanbang.me.flatform.remote.response.user.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IUserApi {
    @GET("/users/{user}")
    Flowable<User> getUser(@Path("user") String userId);
}
