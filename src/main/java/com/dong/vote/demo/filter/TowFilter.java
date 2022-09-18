package com.dong.vote.demo.filter;

import org.springframework.stereotype.Component;

/**
 * @author: dongxiaohua
 * @date: 2022-09-18 15:13:03
 */
@Component("tow")
public class TowFilter implements RuleFilter {
  @Override
  public boolean checkRule(Object o) {
    return false;
  }
}
