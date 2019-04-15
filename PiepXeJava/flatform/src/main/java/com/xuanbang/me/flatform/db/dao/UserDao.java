package com.xuanbang.me.flatform.db.dao;


import com.xuanbang.me.flatform.remote.response.user.User;

import java.util.Date;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Flowable;

/**
 * Data Access Object for the users table.
 */
@Dao
public interface UserDao {

    /**
     * Get the user from the table. Since for simplicity we only have one user in the database,
     * this query gets all users from the table, but limits the result to just the 1st user.
     *
     * @return the user from the table
     * Issue: Link: https://codinginfinite.com/android-room-persistent-rxjava/
     */

    /**
     * Get user login from database
     */
    @Query("SELECT * FROM user LIMIT 1")
    Flowable<List<User>> getUser();

    @Query("SELECT * FROM user WHERE login = 'bangdinh' AND lastRefresh >= :lastRefreshMax LIMIT 1")
    User hasUser(Date lastRefreshMax);

    /**
     * Get
     */
    @Query("SELECT * FROM user WHERE login = :userLogin")
    Flowable<List<User>> getUser(String userLogin);

    @Query("SELECT * FROM user WHERE login = :userLogin AND lastRefresh > :lastRefreshMax LIMIT 1")
    User hasUser(String userLogin, Date lastRefreshMax);

    /**
     * Save user to table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(User user);//Completable

    @Update
    void updateTime(User user);

    /**
     * Delete all users.
     */
    @Query("DELETE FROM user")
    void deleteAllUsers();
}
