package com.test.demo.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/10/15 21:36
 */
@Configuration
@ComponentScan("com.test.demo.uid")
public class Test {


	public static void test() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				= new AnnotationConfigApplicationContext(Test.class);
		//Appconfig appconfig = annotationConfigApplicationContext.getBean(Appconfig.class);

		annotationConfigApplicationContext.getBean( TestService.class);
	}
}
