package com.itheima.JDBC;

import java.util.List;

public interface AccountDao {
    //添加
    public int addAccount(Account account);

    //更新
    public int updateAccount(Account account);

    //删除
    public  int deleteAccount(int userNumber);

    //通过 id 查询账户数据信息
    public Account findAccountByUserNumber(int userNumber);

    //查询所有账户
    public List<Account> findAllAccount();
}
