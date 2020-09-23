package com.itheima.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    public static void main(String[] args) {
        String xmlPath =
                "aop_annotation_applicationContext.xml";

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);

        //1、从Spring容器获得内容
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        //2、执行方法
        userDao.addUser();
    }
}
