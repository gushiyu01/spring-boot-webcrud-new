package com.gushiyu.springbootwebcrud.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;



import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(String username, String password, Map<String,Object> map, HttpSession hs){
        if(!"admin".equals(username) || !"123456".equals(password)){
            map.put("msg","用户名或密码错误");
            return "login";
        }else{
            hs.setAttribute("token","success");
            hs.setAttribute("username",username);
            return "redirect:/main.html";
        }

    }
}
