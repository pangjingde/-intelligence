package com.cy.store.mapper;


import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTest {

    @Autowired
    DistrictMapper districtMapper;

    @Test
    public  void CountTest(){
        List<District> list = districtMapper.findByParent("210100");
        for (District district : list) {
            System.out.println(district);
        }

    }
    @Test
    public  void CountTest1(){
        List<District> list = districtMapper.findByParent("86");
        for (District district : list) {
            System.out.println(district);
        }

    }

    @Test
    public  void findNameByCode(){
        String list = districtMapper.findNameByCode("610000");
        System.out.println(list);

    }

}
