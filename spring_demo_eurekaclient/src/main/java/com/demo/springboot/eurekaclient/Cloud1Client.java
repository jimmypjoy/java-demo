package com.demo.springboot.eurekaclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "SPRING-DEMO-CLOUD1")  // Name should match the application name of cloud1
public interface Cloud1Client {

    @GetMapping("/hello")
    String getHello();
}