package com.cy.store.service;


import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {


    @Autowired
    private  IUserService UserService;
    @Test
    public void reg(){

        try {
            User user=new User();
            user.setUsername("ppp");
            user.setPassword("123");
            UserService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }


    @Test
    public  void login(){
        User UserLogin = UserService.login("Tom001","123456");
        System.out.println(UserLogin);
    }


    @Test
    public void changePassword(){
        UserService.changePassword(2,"管理员","123456","123");
    }

    @Test
    public void getByUid(){
        User user = UserService.getByUid(2);
        System.out.println(user);
    }
    @Test
    public void changeInfo(){
        User user=new User();
        user.setUid(2);
        user.setPhone("111111");
        user.setEmail("1000@qq.com");
        user.setGender(1);
        UserService.changeInfo(2,"管理员",user);
    }

    @Test
    public  void updateAvatarByUid(){
        UserService.changAvatar(2,"ppp","管理员");
    }

}
