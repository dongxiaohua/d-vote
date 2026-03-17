package com.dong.vote.demo.meituan.es.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:16:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DCCustomerEsModel extends AbstractEsModel {

  private static final SerializeConfig SERIALIZE_CONFIG = new SerializeConfig();

  /**
   * 当前特有字段
   */
  private String id;



  /**
   * 文档key
   *
   * @return
   */
  public String buildKey(){
    return this.id;
  }

  /**
   * 转换为index数据的抽象方法
   *
   * @return
   */
  public Map<String, Object> buildIndexData(){
    return (JSONObject) JSON.toJSON(this, SERIALIZE_CONFIG);
  }

  /**
   * 文档路由
   *
   * @return
   */
  public String routing(){
    return null;
  }
}
