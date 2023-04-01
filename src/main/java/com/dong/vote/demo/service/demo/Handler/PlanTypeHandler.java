package com.dong.vote.demo.service.demo.Handler;

import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author: dongxiaohua
 * @date: 2023-04-01 22:55:20
 */
@Component
public class PlanTypeHandler extends AbstractPlanRuleHandler<Set<Long>> {


  @Override
  public String getType() {
    return "type";
  }

  @Override
  protected Set<Long> getResult() {
    return null;
  }

  @Override
  protected boolean checkRule(Set<Long> longs) {
    return false;
  }


}
