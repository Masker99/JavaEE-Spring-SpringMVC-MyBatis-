package com.itheima.annotation;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("userService")//将该类标识为Spring中的Bean
public class UserServiceImpl implements UserService{
    @Resource(name="userDao")//将属性与名为“userDao”的bean依赖
    private UserDao userDao;

    public void save() {
        //调用userDao中的save方法
        this.userDao.save();
        System.out.println("userservice...save...");
    }

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
}
