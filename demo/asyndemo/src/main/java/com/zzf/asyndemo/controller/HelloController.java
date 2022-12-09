package com.zzf.asyndemo.controller;

import com.zzf.asyndemo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    private  static  final Logger log = LoggerFactory.getLogger(HelloController.class);

    ThreadLocal threadLocal;
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(1);
        helloService.hello();
        System.out.println(3);
        return "hello Swagger";
    }

    public int add1(int a, int b){
        b = b-1;
        return a;
    }


}
