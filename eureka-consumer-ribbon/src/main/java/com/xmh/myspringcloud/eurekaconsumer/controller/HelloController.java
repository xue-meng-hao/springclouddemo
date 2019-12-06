package com.xmh.myspringcloud.eurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String hello(@RequestParam String name) {
        name += "!";
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-producer");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello/?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }
}
