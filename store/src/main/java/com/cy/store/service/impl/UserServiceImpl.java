package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;

import java.util.Date;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        String username = user.getUsername();
        User result = userMapper.findByUsername(username);
        if (result != null) {
            throw new UsernameDuplicatedException("用户名被占用");
        }
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        user.setCreatedTime(new Date());
        user.setModifiedTime(new Date());

        Integer row = userMapper.insert(user);

        if (row != 1) {
            throw new InsertException("用户在注册过程中产生了未知错误");
        }

    }

    /**
     * @param username
     * @param password
     * @return 登录认证
     */

    @Override
    public User login(String username, String password) {

        User result = userMapper.findByUsername(username);
        if (result == null) {
            throw new UserNotFoundException("用户不存在");
        }

        String oldPassword = result.getPassword();

        if (!oldPassword.equals(password)) {
            throw new PasswordNotMatchException("密码错误");
        }
    /*    String salt = result.getSalt();
        String newMd5Password = getMd5Password(oldPassword, salt);

    if (!newMd5Password.equals(oldPassword)){
        throw  new PasswordNotMatchException("密码错误");
    }*/

        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getSalt());

        return user;
    }

    /**
     * 修改密码
     *
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        String password = result.getPassword();
        if (!password.equals(oldPassword)) {
            throw new UpdateException("密码错误，请输入正确密码");
        }
        Integer row = userMapper.updatePasswordByUid(uid, newPassword, username, new Date());
        if (row != 1) {
            throw new UpdateException("更新异常");
        }
    }

    /**
     * 查询到的数据返回到前端相对于的页面
     *
     * @param uid
     * @return
     */
    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setGender(result.getGender());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        return user;
    }

    /**
     * 前端更改数据信息，点击修改后就执行这个方法，前端传入phone，email和gender
     *
     * @param uid
     * @param username
     * @param user
     */
    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        if (rows != 1) {
            throw new UpdateException("更新异常");
        }
    }

    @Override
    public void changAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if (rows != 1){
            throw new UpdateException("更新异常");
        }
    }
}
