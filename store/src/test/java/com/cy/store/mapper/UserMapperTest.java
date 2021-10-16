package com.cy.store.mapper;


import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {


    @Autowired
    private  UserMapper userMapper;
    @Test
    public void insert(){

        User user=new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }


    @Test
    public void update(){
      userMapper.updatePasswordByUid(2,"123456","管理员",new Date());
    }

    @Test
    public void findByUid(){
        User user = userMapper.findByUid(2);
        System.out.println(user);
    }

    @Test
    public  void userInfo(){
        User user = new User();
        user.setUid(2);
        user.setPhone("15775064821");
        user.setEmail("1098986370@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void updateAvatarByUid(){
    userMapper.updateAvatarByUid(2,"anc","管理员",new Date());
    }
}
