package com.itheima.aop;

//目标类
public class UserDaoImpl implements UserDao{
    public void addUser(){
        System.out.println("添加用户");
    }

    public void deleteUser(){
        System.out.println("删除用户");
    }
}
