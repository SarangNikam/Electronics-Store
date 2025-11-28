package com.electronic.Strore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Home {

    @GetMapping
    public String testing(){
        return "welcome to electroics store";
    }
}
