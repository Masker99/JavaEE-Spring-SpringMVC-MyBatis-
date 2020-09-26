package com.itheima.JDBC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    /**
     * 使用execute（）方法建表
     * execute()方法 执行
     */
    public static void main(String[] args) {
        //加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("JDBC_applicationContext.xml");

        //获取JDBCTemplate实例
        JdbcTemplate jdbcTemplate =
                (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        //使用execute()方法执行语句，创建用户管理表account -- [account 在mysql中属于关键字，改为test]
        jdbcTemplate.execute("create table test(userNumber int primary key ,userName varchar(50),balance_test double)");

        System.out.println("账户表test创建成功!");
    }

    @Test
    public void addAccountTest(){
        //加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("JDBC_applicationContext.xml");

        //获取 AccountDao 实例
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");

        //创建 Account 对象，并向 Account 对象中添加数据
        Account account = new Account();

        account.setUserNumber(1);
        account.setUserName("tom");
        account.setBalance(1000.00);

        //执行 addAccount() 方法，并获取返回结果
        int num = accountDao.addAccount(account);

        if (num > 0){
            System.out.println("成功插入了"+num+"条数据！");
        }else {
            System.out.println("插入操作执行失败！");
        }
    }
}
