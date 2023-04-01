package com.dong.vote.demo.service.demo.Handler;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: dongxiaohua
 * @date: 2023-04-01 22:50:26
 */
public abstract class AbstractPlanRuleHandler<Result> implements ApplicationContextAware {



  public abstract String getType();

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//      applicationContext.getBean();
  }


  protected abstract Result getResult();

  protected abstract boolean checkRule(Result result);
}
