package com.xuanbang.me.domain.entity;

import com.google.gson.GsonBuilder;

import java.util.Date;

public class UserEntity {

    public String id;

    public String login;

    public String avatar_url;

    public String name;

    public String company;

    public String blog;

    public Date lastRefresh;

    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this);
    }
}
