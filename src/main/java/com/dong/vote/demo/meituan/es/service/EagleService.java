package com.dong.vote.demo.meituan.es.service;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:59:57
 */
@Service
@Slf4j
public class EagleService {

  @Resource
  private RestHighLevelClient readClient;

  @Resource
  private RestHighLevelClient writeClient;


  public BulkResponse bulk(BulkRequest bulkRequest) throws IOException {
    return writeClient.bulk(bulkRequest, RequestOptions.DEFAULT);
  }

  public SearchResponse search(SearchRequest searchRequest) throws IOException {
    return readClient.search(searchRequest, RequestOptions.DEFAULT);
  }
}
