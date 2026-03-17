package com.dong.vote.demo.meituan.es.enums;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:56:09
 */
public enum EsIndexEnum {

  DEFULE("index"),
  ;

  private final String index;

  EsIndexEnum(String index) {
    this.index = index;
  }

  public String getIndex(){
    return this.index;
  }
}
