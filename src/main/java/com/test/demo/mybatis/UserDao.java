package com.test.demo.mybatis;


import org.apache.ibatis.annotations.Mapper;
 
@Mapper
public interface UserDao {
 
    int insertUser(User user);
 
    User getUserById(Integer uid);
 
    int updateUser(User user);
 
    int deleteUserById(Integer uid);
}
