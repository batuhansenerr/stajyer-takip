package com.batuhansener.stajyerTakip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping
    public String hellloWorldPrivate(){
        return "Hello world! from private";
    }

    @GetMapping("/user")
    public String hellloWorldUserPrivate(){
        return "Hello world! from user private";
    }

    @GetMapping("/admin")
    public String hellloWorldAdminPrivate(){
        return "Hello world! from admin private";
    }
}