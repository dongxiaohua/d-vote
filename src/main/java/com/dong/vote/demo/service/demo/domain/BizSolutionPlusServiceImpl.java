package com.dong.vote.demo.service.demo.domain;

import com.dong.vote.demo.service.demo.BizSolutionPlusService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: dongxiaohua
 * @date: 2023-04-01 22:44:05
 */
@Component
public class BizSolutionPlusServiceImpl implements BizSolutionPlusService {
  @Override
  public <T extends OrginalBizSolution> List<T> crossSolutionRules(List<T> solutions) {
    return null;
  }
}
