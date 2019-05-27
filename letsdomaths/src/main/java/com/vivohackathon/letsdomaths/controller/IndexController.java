package com.vivohackathon.letsdomaths.controller;

import com.vivohackathon.letsdomaths.bean.User;
import com.vivohackathon.letsdomaths.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "hello webserver!";
    }

    @RequestMapping(value = "/")
    public String index(){
        return "login";
    }
    @RequestMapping(value = "/login" , method = {RequestMethod.POST})
    @ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        if (null!=userService.get(username,password)){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/reg" , method = {RequestMethod.POST})
    @ResponseBody
    public String reg(@RequestParam("username") String username,
                      @RequestParam("password") String password){
        if (null!=userService.getByName(username)){
            return "用户名已存在!";
        }else {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            userService.add(user);
            return "success";
        }
    }
}
