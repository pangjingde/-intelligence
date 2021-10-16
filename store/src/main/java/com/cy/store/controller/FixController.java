package com.cy.store.controller;

import com.cy.store.entity.Fix;
import com.cy.store.service.IFixService;
import com.cy.store.until.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fix")
public class FixController extends  BaseController{

    @Autowired
    private IFixService fixService;
    @RequestMapping("/computer")
    public JsonResult<Void> fix(Fix fix){
        fixService.insert(fix);
        return  new JsonResult<Void>(OK);
    }


}
