package com.nine.app.dal.repository;

import com.nine.app.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author wangjia
 * @date 2018-11-22
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    /**
     * findByUsername
     *
     * @param username
     *
     * @return
     */
    User findByUsername(String username);

    /**
     * findByEmail
     *
     * @param email
     *
     * @return
     */
    User findByEmail(String email);

    /**
     * 修改密码
     *
     * @param username
     * @param pass
     */
    @Modifying
    @Query(value = "update user set password = ?2 , last_password_reset_time = ?3 where username = ?1", nativeQuery = true)
    void updatePass(String username, String pass, Date lastPasswordResetTime);

    /**
     * 修改头像
     *
     * @param username
     * @param url
     */
    @Modifying
    @Query(value = "update user set avatar = ?2 where username = ?1", nativeQuery = true)
    void updateAvatar(String username, String url);

    /**
     * 修改邮箱
     *
     * @param username
     * @param email
     */
    @Modifying
    @Query(value = "update user set email = ?2 where username = ?1", nativeQuery = true)
    void updateEmail(String username, String email);
}
