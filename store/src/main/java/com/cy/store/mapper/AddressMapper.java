package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface AddressMapper {
    /**
     * 插入用户饿收货地址数据
     * @param address
     * @return
     */
    Integer insert (Address address);

    /**
     * 查询购物车的行数
     * @param uid
     * @return
     */
     Integer countByUid (Integer uid);

    /**
     * 根据UId查询Address的信息
     * @param uid
     * @return
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据aid查询收货地址
     * @param aid
     * @return
     */
    Address findByAid(Integer aid);

    /**
     * 根据用户的uid的值来修搞用户地址设置为非默认
     * @param uid
     * @return
     */
    Integer updateNonDefault(Integer uid);

    /**
     *
     * @param aid
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateDefaultByAid(@Param("aid") Integer aid, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime")Date modifiedTime );

    /**
     * 根据Aid删除收货地址
     * @param aid
     * @return
     */
    Integer deleteByAid(Integer aid);


    /**
     * 根据uid查找用户最近更改的记录
     * @param uid
     * @return
     */
    Address findLastModified(Integer uid);

}
