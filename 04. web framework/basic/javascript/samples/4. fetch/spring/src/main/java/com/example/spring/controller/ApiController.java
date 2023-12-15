package com.example.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/index")
    public Map<String, Object> index() {

        Map<String, Object> map = new HashMap<>();
        map.put("msg", "Spring에서 왔어요~");
        return map;
    }

    @GetMapping("/number")
    public Map<String, Object> number(@RequestParam Map<String, Object> params) {
        params.put("msg", "Spring에서 왔어요~");
        return params;
    }
}
