package com.cy.store.mapper;

import com.cy.store.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    /**
     *  热绑查询
     */

    List<Product> findHotList();

    /**
     * 根据Id查询商品的具体页面
     * @param id
     * @return
     */
    Product findById(Integer id);

}
