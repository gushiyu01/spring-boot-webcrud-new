package com.gushiyu.springbootwebcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {

    @GetMapping("/emps")
    public String list(){

        return "list";
    }
}
