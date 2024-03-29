package cn.wolfcode.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
    @Value("${env}")
    private String env;
    @RequestMapping("/hello")
    public String hello(){
        return  "product-server ====>env"+env;
    }

}
