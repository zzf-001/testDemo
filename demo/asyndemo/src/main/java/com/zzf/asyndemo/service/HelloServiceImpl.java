package com.zzf.asyndemo.service;


import com.zzf.asyndemo.myAsync.MyAsync;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{
    @MyAsync
    public  String hello(){
        System.out.println(Thread.currentThread().getName()+"异步方法开始执行");
        System.out.println(Thread.currentThread().getName()+2);
        return "123";
    }

}
