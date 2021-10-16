package com.cy.store.mapper;


import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTest {

    @Autowired
    AddressMapper addressMapper;

    @Test
    public  void AddressTest(){
        Address address=new Address();
        address.setUid(2);
        address.setPhone("15775064821");
        address.setName("女朋友");
        addressMapper.insert(address);
    }
    @Test
    public  void CountTest(){
        Integer count = addressMapper.countByUid(2);
        System.out.println(count);
    }

    @Test
    public  void findByUId(){
        List<Address> list = addressMapper.findByUid(2);
        System.out.println(list);
    }

    @Test
    public  void findByAid(){
        System.err.println(addressMapper.findByAid(1));
    }
    @Test
    public  void updateDefaultByAid(){
    addressMapper.updateDefaultByAid(1,"明明",new Date());
    }
    @Test
    public  void updateDefaultNon(){
        addressMapper.updateNonDefault(2);
    }

    @Test
    public  void deleteByAid(){
        System.out.println(addressMapper.findLastModified(2));

    }
}
