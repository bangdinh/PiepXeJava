package com.xuanbang.me.flatform.remote.response.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
    @SerializedName("id")
    @Expose
    public String id;

    @ColumnInfo(name = "login")
    @SerializedName("login")
    @Expose
    public String login;


    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatar_url")
    @Expose
    public String avatar_url;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    public String name;

    @ColumnInfo(name = "company")
    @SerializedName("company")
    @Expose
    public String company;

    @ColumnInfo(name = "blog")
    @SerializedName("blog")
    @Expose
    public String blog;

    public Date lastRefresh;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", blog='" + blog + '\'' +
                ", lastRefresh=" + lastRefresh +
                '}';
    }
}
