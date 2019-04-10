package com.xuanbang.me.piepxe.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.GsonBuilder;

import androidx.annotation.NonNull;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class UserModel implements Parcelable {

    public String id;

    public String login;

    public String avatar_url;

    public String name;

    public String company;

    public String blog;

    public UserModel() {
    }

    private UserModel(Parcel in) {
        id = in.readString();
        login = in.readString();
        avatar_url = in.readString();
        name = in.readString();
        company = in.readString();
        blog = in.readString();

    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };



    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(login);
        dest.writeString(avatar_url);
        dest.writeString(name);
        dest.writeString(company);
        dest.writeString(blog);
    }


    @NonNull
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this);
    }
}
