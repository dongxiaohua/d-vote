package com.dong.vote.demo.meituan.es.service;

import com.dong.vote.demo.meituan.es.BasePageData;
import com.dong.vote.demo.meituan.es.OperateEsResponse;
import com.dong.vote.demo.meituan.es.model.AbstractEsModel;
import com.dong.vote.demo.meituan.es.model.AbstractEsSearchModel;

import java.util.List;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:50:40
 */
public interface EsBaseService<T extends AbstractEsModel, K extends AbstractEsSearchModel> {

  OperateEsResponse batchInsert(List<T> esModels);

  BasePageData<T> pageSearch(K param);

}
