package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DistrictMapper {


    /**
     * 根据父代码的编号，查找对应的列表
     * @param parent  数据库中的父代码
     * @return
     */
    List<District> findByParent(String parent);


    /**
     * 根据code寻找结果
     * @param code 子代码
     * @return
     */
    String findNameByCode(String code);


}
