package com.dong.vote.demo.meituan.chain;

import java.util.Objects;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 20:50:02
 */
public abstract class AbstractEnrollPreChecker implements IEnrollPreCHecker {

  private AbstractEnrollPreChecker nextChecker;

  public void setNextChecker(AbstractEnrollPreChecker nextChecker){
    this.nextChecker = nextChecker;
  }

  public AbstractEnrollPreChecker getNextChecker(){
    return this.nextChecker;
  }


  public void preCheck(Object o) {
    doPreCheck(o);
    if (Objects.nonNull(getNextChecker())) {
      getNextChecker().preCheck(o);
    }
  }

}
