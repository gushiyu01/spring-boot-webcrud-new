package com.gushiyu.springbootwebcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping({"/","index.html"})
    public String index(){
        return "login";
    }
}
