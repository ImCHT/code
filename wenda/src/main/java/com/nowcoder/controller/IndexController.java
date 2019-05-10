package com.nowcoder.controller;

import com.nowcoder.aspect.LogAspect;
import com.nowcoder.model.User;
import com.nowcoder.service.WendaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    WendaService wendaService;

    @RequestMapping(path = {"/","/index"},method = {RequestMethod.GET})
    @ResponseBody
    public String index(){
        logger.info("index");
        return "hello nowconder："+wendaService.getMessage(1);
    }

    @RequestMapping(path = {"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("groupId") String gruopId
                            , @PathVariable("userId") int userId
                            , @RequestParam(value="type",defaultValue = "1",required = false) int type
                            , @RequestParam(value="key" ,defaultValue = "key",required = false) String key){
        return String.format("Profiled Page of %s / %d, type=%d key=%s",gruopId,userId,type,key);
    }

    @RequestMapping(path = {"/vm"},method = {RequestMethod.GET})
    public String template(Model model){
        model.addAttribute("value1","v1");
        List<String> colors = Arrays.asList(new String[]{"红","黄","率"});
        model.addAttribute("colors",colors);

        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        model.addAttribute("map",map);

        User user = new User();
        user.setName("li");
        model.addAttribute("user",user);
        return "home";
    }

    @RequestMapping(path = {"/request"},method = {RequestMethod.GET})
    @ResponseBody
    public String request(Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(request.getMethod()+request.getPathInfo()+request.getQueryString()+request.getRequestURI());

        response.addHeader("name","nowcoder");
        response.addCookie(new Cookie("userName","nowcoder"));
        return stringBuilder.toString();
    }

    @RequestMapping(path = {"/redirect/{code}"},method = {RequestMethod.GET})
    public RedirectView redirect(@PathVariable("code") int code,HttpSession session){
        session.setAttribute("message","nowcoder");
        RedirectView red = new RedirectView("/",true);
        if (code==301){
            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        }
        return red;
    }

    @RequestMapping(path = {"/admin"},method = {RequestMethod.GET})
    @ResponseBody
    public String admin(@RequestParam(value = "key") String key){
        if ("admin".equals(key)){
            return "hello admin";
        }
        throw new IllegalArgumentException("参数不对");
    }

    @ExceptionHandler()
    @ResponseBody
    public String error(Exception e){
        return "error"+e.getMessage();
    }
}
