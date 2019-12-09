package com.xmh.myspringcloud.turbin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class TurbinApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbinApplication.class, args);
    }

}
