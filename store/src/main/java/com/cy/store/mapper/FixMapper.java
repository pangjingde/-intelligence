package com.cy.store.mapper;

import com.cy.store.entity.Fix;
import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FixMapper {

    /**
     * 插入新的Fix的数据
     * @param fix
     * @return
     */
    Integer insert(Fix fix);

}
