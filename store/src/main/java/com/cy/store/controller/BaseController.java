package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import com.cy.store.until.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

public class BaseController implements Serializable {

    public   static  final int OK=2000;

    public   static  final String message="注册成功";

    @ExceptionHandler({ServiceException.class,FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result=new JsonResult<>();
        if (e instanceof InsertException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        }else if (e instanceof UsernameDuplicatedException){
            result.setState(5000);
            result.setMessage("注册时发生未知错误");
        } else if (e instanceof AddressCountLimitException ) {
            result.setState(4003);
            result.setMessage("用户收货地址上限");
        } else if (e instanceof AddressNotFoundException){
            result.setState(4004);
            result.setMessage("用户收货地址不存在");
        }else if (e instanceof AccessDeniedException){
            result.setState(4005);
            result.setMessage("用户非法访问");
        } else if (e instanceof ProductNotFundException) {
            result.setState(4006);
            result.setMessage("商品找不到");
        } else if (e instanceof CartNotFoundException) {
            result.setState(4007);
            result.setMessage("购物车不存在");
        }else if (e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("用户不存在");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("密码错误");
        } else if (e instanceof UpdateException) {
            result.setState(5003);
            result.setMessage("更新时发生异常错误");
        } else if (e instanceof UpdateException) {
            result.setState(5004);
            result.setMessage("删除异常");
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("上传的头像是空");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMessage("上传的头像长度过大");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMessage("上传的文件不符合规格");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("上传文件异常");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("上传的头像的IO异常");
        }
        return result;

    }

    protected final  Integer getuidFromSession(HttpSession session){
      return Integer.valueOf( session.getAttribute("uid").toString());

    }


    protected  final  String  getUserFromSession(HttpSession session){

        return session.getAttribute("username").toString();
    }
}
