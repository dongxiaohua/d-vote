package com.dong.vote.demo.repository;

import com.dong.vote.demo.base.BaseMapper;
import com.dong.vote.demo.domain.VoteDO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * @author: dongxiaohua
 * @date: 2022-09-17 14:13:58
 */
@Component
@EnableTransactionManagement
public class VoteRepository extends AbstractConfigRepository<VoteDO> {

  @Resource
  private IVoteMapper voteMapper;

  protected BaseMapper<VoteDO> getMapper(){
    return voteMapper;
  }

}
