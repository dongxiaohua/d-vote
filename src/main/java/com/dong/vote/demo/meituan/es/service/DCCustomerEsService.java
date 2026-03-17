package com.dong.vote.demo.meituan.es.service;

import com.dong.vote.demo.meituan.es.CoverterUtils;
import com.dong.vote.demo.meituan.es.DcCustomerEsFieldConstants;
import com.dong.vote.demo.meituan.es.enums.EsIndexEnum;
import com.dong.vote.demo.meituan.es.model.DCCustomerEsModel;
import com.dong.vote.demo.meituan.es.model.DCCustomerEsSearchModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 22:54:43
 */
@Service
@Slf4j
public class DCCustomerEsService extends AbstractEsService<DCCustomerEsModel, DCCustomerEsSearchModel> {
  @Override
  public EsIndexEnum indexEnum() {
    return EsIndexEnum.DEFULE;
  }

  @Override
  public DCCustomerEsModel buildEsModelFromEs(Map<String, Object> data) {
    DCCustomerEsModel esModel = new DCCustomerEsModel();
    if (CollectionUtils.isEmpty(data)) {
      return esModel;
    }

    esModel.setId(CoverterUtils.cover2String(data.get(DcCustomerEsFieldConstants.ID)));
    return esModel;
  }
}
