package com.xuanbang.me.flatform.db;

import com.xuanbang.me.flatform.converter.DateConverter;
import com.xuanbang.me.flatform.db.dao.UserDao;
import com.xuanbang.me.flatform.remote.response.user.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import static com.xuanbang.me.util.Constant.VERSION_DB;

/**
 * Main database description.
 */
@Database(entities = {User.class}, version = VERSION_DB, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class DbProvider extends RoomDatabase {
    //---DAO----//
    public abstract UserDao userDao();

}
