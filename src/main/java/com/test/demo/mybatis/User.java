package com.test.demo.mybatis;


import javax.persistence.Column;
import javax.persistence.Id;

public class User {
    @Id
    private Integer uId;
    @Column
    private String uName;
 
}