package com.xmh.myspringcloud.eurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author harry_xue
 * @date 2019/12/06
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String hello(@RequestParam String name) {
        name += "!";
        /**
         * 因为 Spring Cloud Ribbon 有一个拦截器，它能够在这里进行实际调用的时候，
         * 自动的去选取服务实例，并将这里的服务名替换成实际要请求的 IP 地址和端口，
         * 从而完成服务接口的调用。
         */
        String url = "http://eureka-producer/hello/?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }
}
