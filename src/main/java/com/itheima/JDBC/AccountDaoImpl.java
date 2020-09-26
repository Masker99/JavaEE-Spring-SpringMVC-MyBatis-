package com.itheima.JDBC;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao{
    //声明 JdbcTemplate 属性及其setter方法
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //添加账户
    public int addAccount(Account account){
        //定义SQL
        String sql =
                "insert into test(userNumber,userName,balance_test) value(?,?,?)";

        //定义数组来存储SQL 语句中的参数
        Object[] obj = new Object[]{
                account.getUserNumber(),
                account.getUserName(),
                account.getBalance()
        };

        //执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.jdbcTemplate.update(sql,obj);

        return num;
    }

    //更新账户
    public int updateAccount(Account account){
        //定义SQL
        String sql =
                "update test set userName=?,balance=? where userNumber=?";

        //定义数组来存储SQL语句中的参数
        Object[] params = new Object[]{
                account.getUserName(),
                account.getBalance(),
                account.getUserNumber()
        };

        //执行更新操作，返回的是受SQL语句影响的记录条数
        int num = this.jdbcTemplate.update(sql,params);

        return num;
    }

    //删除账户
    public int deleteAccount(int userNumber){
        //定义SQL
        String sql =
                "delete from test where id =?";

        //执行删除操作，返回的是受 SQL 语句影响的记录条数
        int num = this.jdbcTemplate.update(sql,userNumber);

        return num;
    }
}
