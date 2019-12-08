package com.xmh.springcloud.eurekaconsumerfeign;

import com.xmh.springcloud.eurekaconsumerfeign.impl.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "eureka-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @GetMapping("/hello/")
    String hello(@RequestParam(value = "name") String name);
}
