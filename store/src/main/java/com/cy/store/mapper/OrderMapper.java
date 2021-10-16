package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 插入订单的数据
     * @param order
     * @return
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单项的数据
     * @param orderItem
     * @return
     */
    Integer insertOrderItem(OrderItem orderItem);


    /**
     * 根据uid查找订单详情的
     * @param uid
     * @return
     */
   List<OrderVo> findOrderByUid(Integer uid);



    /**
     * 根据cid删除购物车记录
     * @param oid
     * @return
     */
    Integer deleteByOid(Integer oid);


    Integer deleteById(Integer id);




}
