package com.dong.vote.demo.meituan.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 20:54:36
 */
@Component
@Slf4j
@Order(0)
public class IEnrollOtherChecker extends AbstractEnrollPreChecker {
  @Override
  public void doPreCheck(Object e) {

  }
}
