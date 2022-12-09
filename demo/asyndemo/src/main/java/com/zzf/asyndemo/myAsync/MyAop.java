package com.zzf.asyndemo.myAsync;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class MyAop {
    @Around(value = "@annotation(com.zzf.asyndemo.myAsync.MyAsync)")
    public Object around(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("目标方法前");
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        joinPoint.proceed();//目标方法
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }).start();
            System.out.println("目标方法后");
            return "环绕通知";
        }catch (Exception e){
            return "系统错误";
        } catch (Throwable throwable) {
            return "系统错误";
        }

    }
}
