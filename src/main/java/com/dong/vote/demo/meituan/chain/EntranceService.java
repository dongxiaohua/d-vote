package com.dong.vote.demo.meituan.chain;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 入口
 *
 * @author: dongxiaohua
 * @date: 2026-03-07 20:55:51
 */
public class EntranceService {

  private List<AbstractEnrollPreChecker> checkerList;

  private AbstractEnrollPreChecker checker;


  @PostConstruct
  public void init(){
    for (int i = 0; i < checkerList.size(); i++) {
      if (i == 0) {
        checker = checkerList.get(0);
      } else {
        AbstractEnrollPreChecker currentService = checkerList.get(i-1);
        AbstractEnrollPreChecker nextService = checkerList.get(i);
        currentService.setNextChecker(nextService);
      }
    }
  }


  /**
   * 责任链入口
   * @param o
   */
  public void entrance(Object o){

  }
}
