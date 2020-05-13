package com.test.demo.spring;

import org.springframework.stereotype.Component;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/10/15 21:56
 */
@Component
public class TestService {

	public TestService(){
		System.out.println( "init" );
	}
}
