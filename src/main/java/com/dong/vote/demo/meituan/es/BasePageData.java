package com.dong.vote.demo.meituan.es;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 22:40:34
 */
@Data
public class BasePageData<T> implements Serializable {

  private long total;

  private List<T> list;

  private int pageNo;

  private int pageSize;

  private String searchType;

  private List<String> sortValues;



}
