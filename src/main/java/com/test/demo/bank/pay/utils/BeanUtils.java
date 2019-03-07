package com.test.demo.bank.pay.utils;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author: LKP
 * @date: 2019/1/2
 */
@Service
public class BeanUtils implements ApplicationContextAware {
 
    private static ApplicationContext applicationContext;
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.applicationContext = applicationContext;
    }
 
    /**
     * 把继承该类的 类成员变量 （通过spring 管理的bean）注入到继承的类中去
     */
    public BeanUtils() {
        //加载继承该类的类，扫描成员变量
        Reflections reflections = new Reflections(this.getClass(), new FieldAnnotationsScanner());
 
        //将所有含有Resource注解的成员变量 扫描出来
        Set<Field> fields = reflections.getFieldsAnnotatedWith(Resource.class);
 
        //循环遍历成员变量
        for (Field field : fields) {
            //循环的目的就是把这些为null的不被spring管理的注入对象，手动从applicationContext 取出来，
            //然后设置进去。
 
            try {
                //获得成员变量的类名
                String simpleName = field.getType().getSimpleName();
                //因为我们Spring里面管理bean 的name 都是首字母小写的，所以我们需要把首字母转为小写
                String beanName = toLowerCaseFirstLetter(simpleName);
                //通过beanname 去applicationContext 去获取 beanName 对象
                Object bean = applicationContext.getBean(beanName);
                if (bean == null) {
                    return;
                }
                //我们必须要打破封装
                field.setAccessible(true);
                //把spring管理的对象  设置到我们反射出来的对象中
                field.set(this, bean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * 将首字母变为小写
     * @param beanName
     * @return
     */
    public String toLowerCaseFirstLetter(String beanName){
        String newBeanName = beanName.substring(0, 1).toLowerCase() +
                beanName.substring(1, beanName.length());
        return newBeanName;
    }
}
