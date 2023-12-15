package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
