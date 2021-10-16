package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.entity.District;
import com.cy.store.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartMapperTest {

    @Autowired
   CartMapper cartMapper;

    @Test
    public  void insert(){
        Cart cart = new Cart();
        cart.setUid(2);
        cart.setPid(10000011);
        cart.setNum(2);
        cart.setPrice(1000L);
        cartMapper.insert(cart);
    }

    @Test
    public  void update(){
        cartMapper.updateNumByCid(3,4,"管理者",new Date());
    }

    @Test
    public  void  select(){
     cartMapper.findByUidAndPid(2,10000011);
    }

    @Test
    public  void  cartVo(){
        System.out.println(cartMapper.findVoByUid(2));
    }

    @Test
    public void findByCid() {
        Integer cid = 3;
        Cart result = cartMapper.findByCid(cid);
        System.out.println(result);
    }
    @Test
    public void deleteByCid() {
        Integer cid = 11;
        Integer result = cartMapper.deleteByCid(cid);
        System.out.println(result);
    }

    @Test
    public void findVOByCids() {
        Integer[] cids = {1, 14, 16, 7, 8, 9, 10};
        List<CartVO> list = cartMapper.findVOByCids(cids);
        System.out.println("count=" + list.size());
        for (CartVO item : list) {
            System.out.println(item);
        }
    }
}
