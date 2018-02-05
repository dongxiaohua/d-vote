package com.dong.vote.service.impl;

import com.dong.vote.entity.VoteOption;
import com.dong.vote.mapper.VoteOptionMapper;
import com.dong.vote.service.VoteOptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
@Service
@Slf4j
public class VoteOptionServiceImpl implements VoteOptionService {
  @Resource
  private VoteOptionMapper voteOptionMapper;

  @Override
  public int insertOption(VoteOption voteOption) {
    return voteOptionMapper.insert(voteOption.getOptionName(),voteOption.getVoteId(),voteOption.getOptionPoll());
  }
}
