package com.example.controlerprepare.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    private static long visitCount = 0;

    @GetMapping("/static-hello")    //직접 들어가기   정적인 페이지
    public String hello(){
        return "hello.html";
    }

    @GetMapping("/html/redirect")
    public String htmlStatic(){
        return "redirect:/hello.html";
    }

    @GetMapping("/html/templates")
    public String htmlTemlplates(){
        return "hello";
    }

    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model){
        visitCount++;
        model.addAttribute("visit", visitCount);
        return "hello-visit";

    }
}
