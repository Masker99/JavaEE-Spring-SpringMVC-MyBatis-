package com.itheima.JDBC;

public interface AccountDao {
    //添加
    public int addAccount(Account account);

    //更新
    public int updateAccount(Account account);

    //删除
    public  int deleteAccount(int userNumber);
}
