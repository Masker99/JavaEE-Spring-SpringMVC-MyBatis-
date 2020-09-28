package com.itheima.transaction;

public class Account {
    private Integer userNumber;//账户ID
    private String userName;//用户名
    private Double balance;//账户余额

    public Integer getUserNumber(){
        return userNumber;
    }

    public void setUserNumber(Integer userNumber){
        this.userNumber = userNumber;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public Double getBalance(){
        return balance;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }

    public String toString(){
        return "Account[id="+userNumber+","+
                "userName="+userName+
                ",balance="+balance+"]";
    }
}
