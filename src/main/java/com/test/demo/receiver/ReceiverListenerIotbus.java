package com.test.demo.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiverListenerIotbus {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
 

  @RequestMapping("/order")
  public void processMap(@RequestParam String type, @RequestParam String text) {

    String beanName = AnnoManageUtils.getBeanNameByEventType(type);
    // 接收的事件类型找不到对应的业务处理，不进行业务处理
    if (null == beanName) {
      return;
    }
    try {
      AbstractMessageHandler messageHandler = (AbstractMessageHandler) SpringUtils.getBean(beanName);
      // 注入对应的类进行业务处理
      messageHandler.doProcess(text);
    } catch (Exception e) {
      logger.error("处理信息出错{}",e);
    }
  }
 
}
