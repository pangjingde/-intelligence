package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.until.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController extends  BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/logout")
    public void logout(HttpSession session,HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("../index.html");

    }

    @RequestMapping("/reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return  new JsonResult<Void>(OK,message);
    }

    /*@RequestMapping("/reg")
    public JsonResult<Void> reg(User user){

        JsonResult<Void> result=new JsonResult<>();
        try {
            userService.reg(user);
            result.setState(200);
            result.setMessage("用户注册成功");
        } catch (UsernameDuplicatedException e) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        }catch (InsertException e){
            result.setState(500);
            result.setMessage("注册是产生错误");
        }
        return  result;
    }*/

    @RequestMapping("/login")
    public  JsonResult<User> login(String username, String password, HttpSession session){
        User data = userService.login(username,password);
        session.setAttribute("username",data.getUsername());
        session.setAttribute("uid",data.getUid());
        System.out.println(getuidFromSession(session));
        System.out.println(getUserFromSession(session));
        return new JsonResult<User>(OK,data);
    }




    @RequestMapping("/change_password")
    public  JsonResult<Void>  changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);

        userService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/get_byUid")
    public  JsonResult<User> getByUid(HttpSession session){
        User data = userService.getByUid(getuidFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("/change_info")
    public  JsonResult<Void> changeInfo(User user,HttpSession session){
    //user有四个数据 ：username,phone,email,gender
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);
        userService.changeInfo(uid,username,user);
        return new JsonResult<>(OK);
    }

    //最大上传文件大小
    public static  final  int Avatar_MAX_SIZE= 10*1024*1024;
    //文件的类型
    public static  final List<String> Avatar_TYPE=new ArrayList<>();
    static {
        Avatar_TYPE.add("image/jpeg");
        Avatar_TYPE.add("image/png");
        Avatar_TYPE.add("image/bmp");
        Avatar_TYPE.add("image/gif");
        Avatar_TYPE.add("image/jpg");
    }

    @RequestMapping("/change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, @RequestParam("file")MultipartFile file){

        if (file.isEmpty()){
            throw  new FileEmptyException("文件为空");
        }if (file.getSize()>Avatar_MAX_SIZE){
            throw  new FileSizeException("文件超出大小");
        }if (!Avatar_TYPE.contains(file.getContentType())){
            throw  new FileTypeException("文件类型不支持");
        }
        String parent = session.getServletContext().getRealPath("upload");
        File dir = new File(parent);
        if (!dir.exists()){
         dir.mkdir();
        }
        //获取后缀名
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        //生成UUID
        String filename = UUID.randomUUID().toString().toUpperCase()+suffix;
        File dest=new File(dir,filename);
        if (!dest.exists()){
           dest.mkdir();
        }
        try {
            file.transferTo(dest);
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        }catch (IOException e){
            throw new FileUploadIOException("文件读写异常");
        }
        Integer uid = getuidFromSession(session);
        String username = getUserFromSession(session);
        String avatar="/upload/"+filename;
        userService.changAvatar(uid,avatar,username);
        return new JsonResult<> (OK,avatar);
    }


    @RequestMapping("/showName")
    public JsonResult<String> getUserName(HttpSession session){
        String data = getUserFromSession(session);
        return new JsonResult<>(OK,data);
    }


}
