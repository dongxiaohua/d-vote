package com.dong.vote.demo.meituan.es.enums;

import lombok.Getter;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:22:35
 */
@Getter
public enum IndexSearchTypeEnum {
  FORM_SIZE("FROM_SIZE", "浅分页查询"),

  SEARCH_AFTER("SEARCH_AFTER", "searchAfter深分页"),

  SCROLL("SCROLL", "scroll深分页");

  public String code;

  public String desc;


  IndexSearchTypeEnum(String code, String desc){
    this.code = code;
    this.desc = desc;
  }

}
