package com.xuanbang.me.flatform.di.module;

import android.app.Application;

import com.xuanbang.me.flatform.db.DbProvider;
import com.xuanbang.me.flatform.db.dao.UserDao;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

import static com.xuanbang.me.util.Constant.NAME_DATABASE;

@Module
public class DbModule {

    // --- DATABASE INJECTION --//
    @Singleton
    @Provides
    DbProvider providePiepxeDatabase(Application application) {
        return Room.databaseBuilder(application, DbProvider.class, NAME_DATABASE)//
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    UserDao provideUserDao(DbProvider piepxeDatabase) {
        return piepxeDatabase.userDao();
    }
}
