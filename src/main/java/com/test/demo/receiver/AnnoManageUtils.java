package com.test.demo.receiver;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class AnnoManageUtils {
  public static Map<String, String> map = new ConcurrentHashMap<>();
 
  static {
    //反射工具包，指明扫描路径
    Reflections reflections = new Reflections("com.test.demo.receiver.handler");
    //获取带Handler注解的类
    Set<Class<?>> classList = reflections.getTypesAnnotatedWith(Handler.class);
    for (Class classes : classList) {
      Handler t = (Handler) classes.getAnnotation(Handler.class);
      String[] valueList = t.value();
      //获取注解的值并循环
      for (String value : valueList) {
        //注解值为key，类名为value
        map.put(value, CommonUtils.normalizeFirstWord(classes.getSimpleName()));
      }
    }
  }
 
  //通过eventTypeId，也就是注解的值获取相应处理Handler的类名
  public static String getBeanNameByEventType(String eventTypeId) {
    return map.get(eventTypeId);
  }
}