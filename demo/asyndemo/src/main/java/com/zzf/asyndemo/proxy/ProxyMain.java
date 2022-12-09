package com.zzf.asyndemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ProxyMain {
    public static void main(String[] args) {
        ExecutorService executorService4 = Executors.newScheduledThreadPool(1);
        ScheduledThreadDemo scheduledThreadDemo = new ScheduledThreadDemo();
        ((ScheduledExecutorService) executorService4).scheduleAtFixedRate(scheduledThreadDemo,5,5, TimeUnit.SECONDS);









//        Class[] interfaces = {UserDao.class};
//        UserDao userDao = new UserDaoImpl();
//        UserDao userDao1 = (UserDao) Proxy.newProxyInstance(ProxyMain.class.getClassLoader(),interfaces,new UserDaoProxy(userDao));
//        int res  =userDao1.add(1,2);
//        System.out.println(res);
    }
}

class UserDaoProxy implements InvocationHandler{

    private UserDao userDao;
    public UserDaoProxy(UserDao userDao){
        this.userDao =userDao;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前"+method.getName()+"传递的参数"+ Arrays.toString(args));
        Object obj = method.invoke(userDao,args);
        System.out.println("执行后"+obj);
        return obj;
    }
}

class ScheduledThreadDemo extends Thread{
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(System.currentTimeMillis()));
        System.out.println("正在运行的线程名字" + Thread.currentThread().getName());
    }

}