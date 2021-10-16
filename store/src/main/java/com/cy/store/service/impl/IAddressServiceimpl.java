package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import com.cy.store.service.ex.*;
import com.cy.store.until.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IAddressServiceimpl implements IAddressService {
    @Autowired
    AddressMapper addressMapper;

    //在填加用户的收货地址的业务层依赖IDistrictService的业务接口
    @Autowired
    DistrictMapper districtMapper;

    @Value("${user.address.max-count}")
    private Integer maxCount;
    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.countByUid(uid);
        if (count>maxCount){
            throw  new AddressCountLimitException("用户的收货地址过多");
        }

        //获取省、市、区
        String provinceName= districtMapper.findNameByCode(address.getProvinceCode());
        String cityName = districtMapper.findNameByCode(address.getCityName());
        String areaName = districtMapper.findNameByCode(address.getAreaCode());

        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        address.setUid(uid);
        Integer isDefault=count ==0?0:1; //1表示默认，0表示不默认
        address.setIsDefault(isDefault);

        address.setCreatedUser(username);
        address.setModifiedUser(username);

        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());

        Integer rows = addressMapper.insert(address);
        if (rows != 1){
            throw  new InsertException("插入异常");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for (Address address : list) {
          /*  address.setAid(null);
            address.setUid(null);*/
            address.setAreaCode(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setTel(null);
            address.setCreatedTime(null);
            address.setCreatedUser(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return list;
    }

    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        Address result = addressMapper.findByAid(aid);
        if (result==null){
            throw new AddressNotFoundException("找不到数据");
        }
        if (!result.getUid().equals(uid)){
                throw  new AccessDeniedException("非法数据");
        }
        Integer rows = addressMapper.updateNonDefault(uid);
        if (rows <1){
            throw  new UpdateException("更新发生异常");
        }
        Integer row = addressMapper.updateDefaultByAid(aid,username,new Date());
        if (row != 1){
            throw  new UpdateException("更新发生异常");
        }
    }

    @Override
    public void delete(Integer aid, Integer uid, String username) {
        Address result = addressMapper.findByAid(aid);
        if (result==null){
            throw  new AddressNotFoundException("用户地址异常");
        }
        if (!result.getUid().equals(uid)){
            throw  new AccessDeniedException("非法数据");
        }
        Integer count = addressMapper.countByUid(uid);

        Integer rows = addressMapper.deleteByAid(aid);
        if (count==0){
            return;
        }
        if (rows!=1){
            throw  new DeleteException("用户删除异常");
        }
        //将这条数据的Is_default设置为1
        Address address  = addressMapper.findLastModified(uid);
        Integer row = addressMapper.updateDefaultByAid(address.getAid(), username, new Date());
        if (row!=1){
            throw  new UpdateException("更新异常");
        }
    }

    @Override
    public Address getByAid(Integer aid, Integer uid) {
        // 根据收货地址数据id，查询收货地址详情
        Address address = addressMapper.findByAid(aid);

        if (address == null) {
            throw new AddressNotFoundException("尝试访问的收货地址数据不存在");
        }
        if (!address.getUid().equals(uid)) {
            throw new AccessDeniedException("非法访问");
        }
        address.setProvinceCode(null);
        address.setCityCode(null);
        address.setAreaCode(null);
        address.setCreatedUser(null);
        address.setCreatedTime(null);
        address.setModifiedUser(null);
        address.setModifiedTime(null);
        return address;
    }


}
