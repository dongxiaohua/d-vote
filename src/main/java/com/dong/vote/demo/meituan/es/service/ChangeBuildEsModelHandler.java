package com.dong.vote.demo.meituan.es.service;

import com.dong.vote.demo.meituan.es.enums.EsIndexEnum;
import com.dong.vote.demo.meituan.es.model.AbstractEsModel;

import java.util.Map;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:55:36
 */
public interface ChangeBuildEsModelHandler<T extends AbstractEsModel> {

  /**
   * 确定对应索引
   *
   * @return
   */
  EsIndexEnum indexEnum();


  /**
   * 变更信息组装转换
   *
   * @param data
   * @return
   */
  T buildEsModelFromEs(Map<String, Object> data);
}
