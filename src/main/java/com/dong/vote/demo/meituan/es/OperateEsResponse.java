package com.dong.vote.demo.meituan.es;

import lombok.Data;

import java.util.Map;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:52:46
 */
@Data
public class OperateEsResponse {
  private Map<String,String> failMap;

  private Boolean hasFail;


  public static OperateEsResponse of(Map<String,String> failMap, boolean hasFail){
    OperateEsResponse resp = new OperateEsResponse();
    resp.setFailMap(failMap);
    resp.setHasFail(false);
    return resp;
  }
}
