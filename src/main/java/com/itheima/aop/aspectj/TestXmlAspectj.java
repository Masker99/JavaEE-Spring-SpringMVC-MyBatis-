package com.itheima.aop.aspectj;

import com.itheima.aop.JDK.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//测试类
public class TestXmlAspectj {
    public static void main(String[] args) {
        String xmlPath = "aspectj_applicationContext.xml";
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);

        //1、从 spring 容器获得内容
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        //2、执行方法
        userDao.addUser();
    }
}
