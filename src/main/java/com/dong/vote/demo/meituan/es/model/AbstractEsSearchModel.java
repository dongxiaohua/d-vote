package com.dong.vote.demo.meituan.es.model;

import com.dong.vote.demo.meituan.es.enums.IndexSearchTypeEnum;
import lombok.Data;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;


/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:21:26
 */
@Data
public abstract class AbstractEsSearchModel {

  private Integer pageNum;

  private Integer pageSize;

  private IndexSearchTypeEnum searchTypeEnum = IndexSearchTypeEnum.FORM_SIZE;

  /**
   * 游标
   */
  private String scrollId;

  /**
   * searchAfter深分页
   */
  private Object[] searchAfter;

  /**
   * 排序字段
   */
  private String sortField;

  /**
   * 排序顺序
   */
  private SortOrder sortOrder;

  /**
   * 组装查询ES
   * @return
   */
  public abstract SearchSourceBuilder searchBuilder();

  /**
   * 校验字段
   */
  public abstract void verified();

}
