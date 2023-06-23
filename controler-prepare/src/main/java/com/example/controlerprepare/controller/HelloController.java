package com.example.controlerprepare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//origin
@Controller
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!!";
    }
    
    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "GET Method 요청";
    }
    
    @PostMapping("/hello")
    @ResponseBody
    public String post(){
        return "POST Method 요청";
    }
    @PutMapping("/put")
    @ResponseBody
    public String put(){
        return "Put Method 요청";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(){
        return "delete method 요청";
    }
    
}
