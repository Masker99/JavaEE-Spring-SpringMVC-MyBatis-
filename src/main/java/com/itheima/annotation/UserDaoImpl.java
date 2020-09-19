package com.itheima.annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao")//标识为Spring中的Bean
public class UserDaoImpl implements UserDao{
    @Override
    public void save(){
        System.out.println("userdao...save...");
    }
}
