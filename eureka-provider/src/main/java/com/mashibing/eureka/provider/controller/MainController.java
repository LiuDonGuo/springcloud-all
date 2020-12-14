package com.mashibing.eureka.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/getHi")
    public String getHi() {
        System.out.println("getHi 22222");
        return "Hi 222";
    }
}
