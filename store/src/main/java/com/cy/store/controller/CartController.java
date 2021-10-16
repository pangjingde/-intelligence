package com.cy.store.controller;

import com.cy.store.service.ICartService;
import com.cy.store.service.ex.DeleteException;
import com.cy.store.until.JsonResult;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session) {
        System.out.println("pid=" + pid);
        System.out.println("amount=" + amount);
        // 从Session中获取uid和username
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);
        // 调用业务对象执行添加到购物车
        cartService.addToCart(uid, pid, amount, username);
        // 返回成功
        return new JsonResult<Void>(OK);
    }



    @RequestMapping({"","/"})
    public  JsonResult<List<CartVO>> getVoByUid(HttpSession session){

        Integer uid = getuidFromSession(session);
        List<CartVO> data = cartService.getVoByUid(uid);
        return new JsonResult<List<CartVO>> (OK,data);
    }

    @RequestMapping("/{cid}/num/add")
    public  JsonResult<Integer> addNum(@PathVariable("cid") Integer  cid, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);
        Integer data = cartService.addNum(cid, uid, username);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("/{cid}/decrease")
    public  JsonResult<Integer> decrease(@PathVariable("cid")Integer cid,HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);
        Integer data = cartService.decrease(cid, uid, username);
        return new JsonResult<>(OK,data);
    }


    @RequestMapping("/{cid}/delete")
    public  JsonResult<Integer> delete(@PathVariable("cid")Integer cid,HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);
        Integer rows = cartService.delete(cid, uid, username);
        if (rows!=1){
            throw  new DeleteException("删除出错了");
        }
        return new JsonResult<>(OK);
    }



    @RequestMapping("/list")
    public JsonResult<List<CartVO>> getByUids(Integer[] cids,HttpSession session){
        List<CartVO> data = cartService.getVOByCids(getuidFromSession(session),cids);
        return new JsonResult<>(OK,data);
    }
}
