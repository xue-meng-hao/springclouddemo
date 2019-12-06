package com.xmh.myspringcloud.eurekaproducer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author harry_xue
 * @date 2019/12/06
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/")
    public String hello(@RequestParam String name) {
        return "hello " + name + " " + new Date();
    }
}
