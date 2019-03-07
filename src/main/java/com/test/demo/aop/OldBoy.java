package com.test.demo.aop;

import java.lang.annotation.*;
 
/**
 * Created by peng on 18/6/29.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OldBoy {
 
}