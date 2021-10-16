package com.cy.store.mapper;


import com.cy.store.entity.Fix;
import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FixMapperTest {

    @Autowired
    private  FixMapper fixMapper;

    @Test
    public void insert(){

        Fix fix = new Fix();
        fix.setName("ppp");
        fix.setAddress("廉江市啊啊");
        fix.setPhone("15775064821");
        fixMapper.insert(fix);
    }



}
