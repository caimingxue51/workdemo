package com.test.demo.stream;

import java.io.Serializable;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/10/22 9:57
 */
public class PersonModel implements Serializable {
    private static final long serialVersionUID = -1313589746425269551L;
    private String name;
    private int age;
    private String sex;


    public PersonModel(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
