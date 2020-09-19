package com.itheima.assemble;

import java.util.List;

public class User {
    private String username;
    private Integer password;
    private List<String> list;

    /*
     *设值注入（Setter Injection）对Bean类的要求：
     * 1、Bean类必须提供一个默认的无参构造方法
     * 2、Bean类必须为需要注入的属性提供对应的setter方法
     */
    public User(){
        super();
        /*
         * 所有的类都是继承自Object类，写不写super（）
         * 都会调用Object类的无参构造方法
         * 这里只是把它显示化了
         */
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    //重写Object类中的toString（）方法
    @Override
    public String toString(){
        return "User[username:"+username+",password="+password+
                ",list="+list+"]";
    }

    /*
     * 使用构造注入（Constructor Injection）
     * 需提供所有带参数的有参构造方法
     */
    public User(String username, Integer password, List<String> list){
        super();
        this.username = username;
        this.password = password;
        this.list = list;
    }
}
