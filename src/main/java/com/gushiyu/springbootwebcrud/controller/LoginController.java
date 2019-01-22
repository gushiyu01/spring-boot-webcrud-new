package com.gushiyu.springbootwebcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(String username, String password, Map map, HttpServletRequest req, HttpSession hs){
        if(StringUtils.isEmpty(username) || "11".equals(password)){
            map.put("msg","用户名或密码错误");
            return "login";
        }
        hs.setAttribute("token","success");
        hs.setAttribute("username",username);
        return "redirect:/main.html";
    }
}
