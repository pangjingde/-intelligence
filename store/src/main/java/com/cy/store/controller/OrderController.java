package com.cy.store.controller;
import com.cy.store.entity.Order;
import com.cy.store.service.ICartService;
import com.cy.store.service.IOrderService;
import com.cy.store.until.JsonResult;
import com.cy.store.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICartService cartService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);
        // 调用业务对象执行业务
        Order data = orderService.create(aid, cids, uid, username);
        // 返回成功与数据
         cartService.deleteByUid(uid);
        return new JsonResult<Order>(OK, data);
    }



    @RequestMapping({"","/"})
    public JsonResult<List<OrderVo>> getOrderByUid(HttpSession session){
        Integer uid = getuidFromSession(session);
        List<OrderVo> data = orderService.getOrderByUid(uid);
        return new JsonResult<>(OK,data);
    }


}