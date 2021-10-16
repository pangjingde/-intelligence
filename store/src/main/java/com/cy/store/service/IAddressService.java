package com.cy.store.service;

import com.cy.store.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;


public interface  IAddressService {

    void addNewAddress (Integer uid,String username,Address address);


     List<Address> getByUid(Integer uid);

    /**
     * 修改某个用户的某条收货地址数据为默认数据
     * @param aid
     * @param uid
     * @param username
     */
     void setDefault(Integer aid,Integer uid,String username);


    /**
     * 删除用户选到的地址
     * @param aid
     * @param uid
     * @param username
     */
     void delete(Integer aid,Integer uid,String username);


    /**
     * 根据收货地址数据的id，查询收货地址详情
     * @param aid 收货地址id
     * @param uid 归属的用户id
     * @return 匹配的收货地址详情
     */
    Address getByAid(Integer aid, Integer uid);
}
