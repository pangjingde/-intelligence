package com.cy.store.service;



import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartServiceTest {

    @Autowired
    ICartService cartService;

   @Test
    public  void add(){
        cartService.addToCart(1,10000001,10,"李四");
    }

    @Test
    public void addNum() {
        try {
            Integer cid = 3;
            Integer uid = 2;
            String username = "管理员";
            Integer num = cartService.addNum(cid, uid, username);
            System.out.println("OK. New num=" + num);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void decrease() {
        try {
            Integer cid = 3;
            Integer uid = 2;
            String username = "管理员";
            Integer num = cartService.decrease(cid, uid, username);
            System.out.println("OK. New num=" + num);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void delete() {
        try {
            Integer cid = 10;
            Integer uid = 2;
            String username = "管理员";
            Integer num = cartService.delete(cid, uid, username);
            System.out.println("OK. New num=" + num);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
