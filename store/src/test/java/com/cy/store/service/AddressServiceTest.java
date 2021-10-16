package com.cy.store.service;


import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTest {


    @Autowired
    private  IAddressService addressService;

    @Test
    public  void  addNewAddress(){
        Address address=new Address();
        address.setUid(2);
        address.setPhone("156666666");
        address.setName("男朋友");

        addressService.addNewAddress(2,"管理员",address);
    }

    @Test
    public  void  setDefault(){
        addressService.setDefault(1,2,"管理员");
    }


    @Test
    public  void  delete(){
        addressService.delete(1,2,"管理员");
    }
}
