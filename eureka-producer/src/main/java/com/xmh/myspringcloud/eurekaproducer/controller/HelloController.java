package com.xmh.myspringcloud.eurekaproducer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/")
    public String hello(@RequestParam String name) {
        return "hello " + name + " "+new Date();
    }
}
