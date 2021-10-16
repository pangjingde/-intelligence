package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/*用户模块的持久层*/
@Mapper
public interface UserMapper {


    /**
     * 插入用户的数据
     * @param user
     * @return
     */
    Integer insert(User user);

    /**
     *根据用户查询用户的数据
     * @param name
     * @return
     */
    User findByUsername(String name);


    /**
     * 根据用户uid来修改数据
     * @param uid  用户ID
     * @param password  新密码
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * 根据用户的Uid来查询用户数据
     * @param uid 用户
     * @return
     */
    User findByUid(Integer uid);


    /**
     * 更改用户信息
     * @param user 用户的信息
     * @return  返回受影响的行数
     */
    Integer updateInfoByUid(User user);


    /**
     * 修改用户头像
     * @Param 中的值必须是SQL文件映射中的#{}的值，解决的是接口方法中的参数和SQL映射文件的#{}不一致
     * 实质就是将参数的Uid传给@Param（”“）中
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid(@Param("uid") Integer uid,
                              @Param("avatar") String avatar,
                              @Param("modifiedUser") String modifiedUser,
                              @Param("modifiedTime") Date modifiedTime);


}
