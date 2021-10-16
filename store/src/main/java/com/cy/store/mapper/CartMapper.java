package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;
import org.apache.ibatis.annotations.Mapper;
import sun.text.normalizer.UBiDiProps;

import java.util.Date;
import java.util.List;

@Mapper
public interface CartMapper {
    /**
     * 插入购物车，返回插入的行数
     * @param cart
     * @return
     */
    Integer insert(Cart cart);

    /**
     * 更新购物车中商品的数据
     * @param cid       购物车Id
     * @param num        数量
     * @param modifiedUser  修改者
     * @param modifiedTime  修改时间
     * @return
     */
     Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);


    /**
     * 根据用户的ID和商品购物车的ID查找购物车的数据
     * @param uid
     * @param pid
     * @return
     */
     Cart findByUidAndPid(Integer uid,Integer pid);

    /**
     * 根据uid查找购物车的数据
     * @param uid
     * @return
     */
      List<CartVO> findVoByUid(Integer uid);


    /**
     * 根据cid查询购物车数据
     * @param cid
     * @return
     */

      Cart findByCid(Integer cid);

    /**
     * 根据cid删除购物车记录
     * @param cid
     * @return
     */
    Integer deleteByCid(Integer cid);

    /**
     * 根据若干个购物车数据id查询详情的列表
     * @param cids 若干个购物车数据id
     * @return 匹配的购物车数据详情的列表
     */
    List<CartVO> findVOByCids(Integer[] cids);


    Integer deleteByUid(Integer uid);

}
