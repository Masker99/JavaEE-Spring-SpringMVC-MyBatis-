package com.itheima.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//测试类
public class TransactionTest {
    @Test
    public void xmlTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("transaction_applicationContext.xml");

        //获取 AccountDao 实例
        AccountDao accountDao =
                (AccountDao)applicationContext.getBean("accountDao");

        //调用实例中的转账方法
        accountDao.transfer("tom","joy",100.00);

        //输出提示信息
        System.out.println("转账成功！");
    }
}
