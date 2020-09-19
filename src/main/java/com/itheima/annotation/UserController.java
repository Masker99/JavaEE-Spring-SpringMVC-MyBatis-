package com.itheima.annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userController")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    public void save(){
        this.userService.save();
        System.out.println("userController...save...");
    }

    public void setUserService(UserService userService){
        this.userService = userService;
    }
}
