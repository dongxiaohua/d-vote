package com.dong.vote.demo.service;

import com.dong.vote.demo.domain.VoteDO;
import com.dong.vote.demo.dto.VoteDTO;
import com.dong.vote.demo.filter.RuleFilter;
import com.dong.vote.demo.repository.AbstractConfigRepository;
import com.dong.vote.demo.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: dongxiaohua
 * @date: 2022-09-18 15:10:37
 */
@Component
public class VoteDemoService extends AbstractVersionService<VoteDO, VoteDTO> implements IVoteDemoService {

  @Autowired
  Map<String, RuleFilter> ruleFilterMap;

  @Resource
  private VoteRepository repository;

  public VoteDemoService(VoteRepository repository) {
    super(repository, "vote");
    this.repository = repository;
  }


  public void demo() {
    RuleFilter oneFilter = ruleFilterMap.get("one");
    RuleFilter towFilter = ruleFilterMap.get("tow");
  }
}
