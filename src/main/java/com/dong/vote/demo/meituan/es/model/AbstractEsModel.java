package com.dong.vote.demo.meituan.es.model;

import java.util.Map;

/**
 * ES文档模块
 * @author: dongxiaohua
 * @date: 2026-03-07 21:12:06
 */
public abstract class AbstractEsModel {

  protected Long addTime;

  protected Long updateTime;

  /**
   * 文档刷新时间
   */
  protected Long refreshTime;

  /**
   * 文档key
   *
   * @return
   */
  public abstract String buildKey();

  /**
   * 转换为index数据的抽象方法
   *
   * @return
   */
  public abstract Map<String, Object> buildIndexData();

  /**
   * 文档路由
   *
   * @return
   */
  public abstract String routing();
}
