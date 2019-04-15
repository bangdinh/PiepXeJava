package com.xuanbang.me.flatform.remote.response.user;

import com.google.gson.GsonBuilder;
import com.xuanbang.me.util.Constant;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Constant.NAME_TABLE_USER)
public class User {

    @PrimaryKey
    @NonNull
    public String id;

    @ColumnInfo(name = "login")
    public String login;

    @ColumnInfo(name = "avatar_url")
    public String avatar_url;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "company")
    public String company;

    @ColumnInfo(name = "blog")
    public String blog;

    @ColumnInfo(name = "lastRefresh")
    public Date lastRefresh;

    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this);
    }

}
