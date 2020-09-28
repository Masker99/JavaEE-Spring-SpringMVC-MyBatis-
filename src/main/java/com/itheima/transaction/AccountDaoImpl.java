package com.itheima.transaction;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class AccountDaoImpl implements AccountDao{
    //声明 JdbcTemplate 属性及其 setter 方法
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //添加账户
    public int addAccount(Account account){
        //定义SQL
        String sql =
                "insert into test(userNumber,userName,balance) value(?,?,?)";

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
                "delete from test where userNumber =?";

        //执行删除操作，返回的是受 SQL 语句影响的记录条数
        int num = this.jdbcTemplate.update(sql,userNumber);

        return num;
    }

    //通过userNumber查询账户数据信息
    public Account findAccountByUserNumber(int userNumber){
        //定义SQL语句
        String sql =
                "select * from test where userNumber = ?";

        //创建一个新的BeanPropertyRowMapper 对象
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>(Account.class);

        //将 userNumber 绑定到 SQL 语句中，并通过RowMapper 返回一个 Object 类型的单行记录
        return this.jdbcTemplate.queryForObject(sql,rowMapper,userNumber);
    }

    //查询所有账户信息
    public List<Account> findAllAccount(){
        //定义 SQL 语句
        String sql = "select * from test";

        //创建一个新的 BeanPropertyRowMapper 对象
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>(Account.class);

        //执行静态的 SQL 查询，并通过 RowMapper 返回结果
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    /**
     * 转账
     * inUser:收款人
     * outUser：汇款人
     * money：收款金额
     */
    public void transfer(String outUser,String inUser,Double money){
        //收款时，收款用户的余额 = 现有余额 + 所汇金额
        String sql_1 =
                "update test set balance = balance + ?"+
                        "where userName = ?";
        this.jdbcTemplate.update(sql_1,money,inUser);

        //模拟系统运行时的突发性问题
        int i = 1/0;

        //汇款时，汇款用户的余额 = 现有余额 - 所汇金额
        String sql_2 =
                "update test set balance = balance - ?"+
                        "where userName = ?";
        this.jdbcTemplate.update(sql_2,money,outUser);
    }
}
