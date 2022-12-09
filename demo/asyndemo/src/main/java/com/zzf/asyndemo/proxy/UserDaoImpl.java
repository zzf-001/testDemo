package com.zzf.asyndemo.proxy;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a,int b) {
        System.out.println("add被执行了");
        return a+b;
    }

    @Override
    public int update(int id) {
        System.out.println("update被执行了");
        return id +1;
    }
}
