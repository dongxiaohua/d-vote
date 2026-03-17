package com.dong.vote.demo.meituan.es.service;

import com.dong.vote.demo.meituan.es.BasePageData;
import com.dong.vote.demo.meituan.es.OperateEsResponse;
import com.dong.vote.demo.meituan.es.model.AbstractEsModel;
import com.dong.vote.demo.meituan.es.model.AbstractEsSearchModel;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:49:51
 */
@Slf4j
public abstract class AbstractEsService<T extends AbstractEsModel, K extends AbstractEsSearchModel> implements EsBaseService<T, K>, ChangeBuildEsModelHandler<T> {

  @Resource
  private EagleService eagleService;


  public OperateEsResponse batchInsert(List<T> esModels){

    Map<String,String> failMap = Maps.newHashMap();
    boolean hasFailure = false;
    List<List<T>> partion = Lists.partition(esModels, 500);

    for (List<T> models : partion) {
      BulkRequest bulkRequest = new BulkRequest();
      models.forEach(insertModel-> {
        IndexRequest indexRequest = buildIndexRequest(insertModel);
        bulkRequest.add(indexRequest);
      });

      try {
        BulkResponse bulkResponse = eagleService.bulk(bulkRequest);
        if (bulkResponse == null) {
          hasFailure = true;
          continue;
        }
        if (bulkResponse.hasFailures()) {
          bulkResponse.forEach(response -> failMap.put(response.getId(),response.getFailureMessage()));
        }
      } catch (Exception e) {

      }
    }

    return OperateEsResponse.of(failMap, hasFailure);
  }



  public BasePageData<T> pageSearch(K paeam){
    paeam.verified();
    try {
      SearchRequest searchRequest = buildRequest(paeam);
      SearchResponse searchResponse = eagleService.search(searchRequest);

      SearchHits searchHits = searchResponse.getHits();
      long count = searchHits.getSortFields() == null ? 0 : searchHits.getTotalHits().value;

      BasePageData<T> pageData = new BasePageData<>();
      pageData.setPageNo(paeam.getPageNum());
      pageData.setPageSize(paeam.getPageSize());
      pageData.setTotal(count);
      if (Objects.isNull(searchHits.getHits())) {
        return pageData;
      }

      List<T> dataList = Arrays.stream(searchHits.getHits()).filter(Objects::nonNull).map(SearchHit::getSourceAsMap).map(this::buildEsModelFromEs).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(dataList)) {
        return pageData;
      }

      pageData.setList(dataList);
      return pageData;
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }


  public IndexRequest buildIndexRequest(T esModel) {
    String key = esModel.buildKey();
    Map<String, Object> data = esModel.buildIndexData();
    return new IndexRequest().id(key).index(indexEnum().getIndex()).routing(esModel.routing()).source(data);
  }

  private SearchRequest buildRequest(K param) {
    SearchRequest searchRequest = new SearchRequest(indexEnum().getIndex());

    SearchSourceBuilder searchSourceBuilder = param.searchBuilder();
    searchRequest.source(searchSourceBuilder);
    return searchRequest;
  }

}
