package com.test.demo.mybatis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDao userDao;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUser() {
        User user = userDao.getUserById( 1 );
        return user;
    }

}