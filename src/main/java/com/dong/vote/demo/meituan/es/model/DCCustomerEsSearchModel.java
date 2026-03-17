package com.dong.vote.demo.meituan.es.model;

import com.dong.vote.demo.meituan.es.DcCustomerEsFieldConstants;
import com.dong.vote.demo.meituan.es.enums.IndexSearchTypeEnum;
import freemarker.template.utility.StringUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 21:32:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DCCustomerEsSearchModel extends AbstractEsSearchModel{

  private Long id;


  @Override
  public SearchSourceBuilder searchBuilder() {
    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

    if (Objects.nonNull(id)) {
      boolQueryBuilder.must(QueryBuilders.termQuery(DcCustomerEsFieldConstants.ID, this.id));
    }

    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(boolQueryBuilder).timeout(new TimeValue(3000, TimeUnit.MICROSECONDS)).size(this.getPageSize());
    if (this.getSearchTypeEnum() == IndexSearchTypeEnum.FORM_SIZE) {
      searchSourceBuilder.from((this.getPageNum() - 1) * this.getPageSize());
    }

    if (!StringUtils.isEmpty(getSortField()) && getSortField() != null) {
      searchSourceBuilder.sort(getSortField(), getSortOrder());
    }

    return searchSourceBuilder;
  }

  @Override
  public void verified() {

  }
}
