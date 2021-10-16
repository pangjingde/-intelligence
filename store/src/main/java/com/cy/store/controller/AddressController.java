package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.until.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController extends  BaseController {

    @Autowired
    private IAddressService addressService;

    @RequestMapping("/addNewAddress")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);

        addressService.addNewAddress(uid,username,address);

        return new JsonResult<>(OK);
    }

    @RequestMapping({"/",""})
    public JsonResult<List<Address>> getByUid(HttpSession session){
        Integer uid = getuidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("/{aid}/set_default")
    public  JsonResult<Void> setDefault(@PathVariable("aid") Integer aid,HttpSession session){

        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);
        addressService.setDefault(aid,uid,username);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/{aid}/delete")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid,HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);
        addressService.delete(aid,uid,username);
        return new JsonResult<>(OK);

    }


}
