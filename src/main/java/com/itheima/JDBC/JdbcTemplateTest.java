package com.itheima.JDBC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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

    @Test
    public void updateAccountTest(){
        //加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("JDBC_applicationContext.xml");

        //获取AccountDao实例
        AccountDao accountDao =
                (AccountDao)applicationContext.getBean("accountDao");

        //创建Account对象,并向Account 对象中添加数据
        Account account = new Account();

        account.setUserNumber(1);
        account.setUserName("tom");
        account.setBalance(2000.00);

        //执行updateAccount（）方法，并获取返回结果
        int num = accountDao.updateAccount(account);

        if (num>0){
            System.out.println("成功修改了"+num+"条数据！");
        }else {
            System.out.println("修改操作执行失败！");
        }
    }

    @Test
    public void deleteAccountTest(){
        //加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("JDBC_applicationContext.xml");

        //获取AccountDao实例
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");

        //执行deleteAccount()方法，并获取返回结果
        int num = accountDao.deleteAccount(1);

        if (num>0){
            System.out.println("成功删除了"+num+"条数据！");
        }else{
            System.out.println("删除操作执行失败！");
        }
    }

    @Test
    public void findAccountByUserNumberTest(){
        //加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("JDBC_applicationContext.xml");

        //获取 AccountDao 实例
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");

        //执行 findAccountByUserNumber（）方法
        Account account = accountDao.findAccountByUserNumber(1);

        System.out.println(account);
    }

    @Test
    public void findAllAccountTest(){
        //加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("JDBC_applicationContext.xml");

        //获取 AccountDao 实例
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");

        //执行 findAllAccount() 方法，获取 Account 对象的集合
        List<Account> account = accountDao.findAllAccount();

        //循环输出集合中的对象
        for(Account act: account){
            System.out.println(act);
        }
    }
}
