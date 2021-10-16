package com.cy.store.service.impl;

import com.cy.store.entity.Fix;
import com.cy.store.mapper.FixMapper;
import com.cy.store.service.IFixService;
import com.cy.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IFixServiceImpl implements IFixService {

    @Autowired
    private FixMapper fixMapper;

    @Override
    public void insert(Fix fix) {
        fix.setCreatedTime(new Date());
        fix.setModifiedTime(new Date());
        Integer rows = fixMapper.insert(fix);
        if (rows!=1){
            throw  new InsertException("插入出错");
        }


    }
}
