package com.dong.vote.demo.service.demo;

import com.dong.vote.demo.service.demo.domain.OrginalBizSolution;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: dongxiaohua
 * @date: 2023-04-01 22:40:21
 */
@Component
public interface BizSolutionPlusService {

  <T extends OrginalBizSolution> List<T> crossSolutionRules(List<T> solutions);
}
