package com.dong.vote.demo.service.demo.Handler;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dongxiaohua
 * @date: 2023-04-01 22:47:57
 */
@Component
public class HandlerFactory implements ApplicationContextAware {

  private final Map<String, AbstractPlanRuleHandler<Object>> typeHandlerMap = new HashMap<>();

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    applicationContext.getBeansOfType(AbstractPlanRuleHandler.class).forEach((key, value) -> {
      this.typeHandlerMap.put(value.getType(), value);
    });
  }
}
