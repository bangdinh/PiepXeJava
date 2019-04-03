package com.xuanbang.me.flatform.db.dao;


import com.xuanbang.me.flatform.remote.response.user.User;

import java.sql.Date;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
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
     */
    @Query("SELECT * FROM user WHERE login = :userLogin")
    Flowable<User> getUser(String userLogin);

    @Query("SELECT * FROM user WHERE login = :userLogin")
    User getUsers(String userLogin);

    @Query("SELECT * FROM user WHERE login = :userLogin AND lastRefresh > :lastRefreshMax LIMIT 1")
    Flowable<User> hasUser(String userLogin, Date lastRefreshMax);

    /**
     * Save user to table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(User user);//Completable

    /**
     * Delete all users.
     */
    @Query("DELETE FROM user")
    void deleteAllUsers();
}
