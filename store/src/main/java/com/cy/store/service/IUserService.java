package com.cy.store.service;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * 业务的接口层，调用了Mapper层
 */
public interface IUserService {
    /**
     * 用户注册方法
     * @param user
     */
        void reg(User user);


    /**
     *
     * @param username
     * @param password
     * @return  当前匹配饿用户数据，如果没有就返回NULL
     *
     */
    User login(String username,String password);


    /**
     * 修改密码设置
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(Integer uid,String username,String oldPassword,String newPassword);

    /**
     * 获得根据uid得到的用户信息
     * @param uid
     * @return
     */

    User getByUid(Integer uid);


    /**
     * 前端提供的动态数据实现
     * @param uid
     * @param username
     * @param user
     */
    void  changeInfo(Integer uid,String username,User user);

    /**
     * 修改头像
     * @param uid id
     * @param avatar 头像的路径
     * @param username 用户名
     */
    void  changAvatar( Integer uid, String avatar, String username);


}
