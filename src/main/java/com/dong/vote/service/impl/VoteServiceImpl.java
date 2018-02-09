package com.dong.vote.service.impl;

import com.dong.vote.entity.Vote;
import com.dong.vote.mapper.VoteMapper;
import com.dong.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
@Service
public class VoteServiceImpl implements VoteService {
  @Autowired
  private VoteMapper voteMapper;


  /**
   * 创建投票
   *
   * @param voteList
   * @return
   */
  @Override
  public int batchInsert(List<Vote> voteList) {
    return voteMapper.batchInsert(voteList);
  }


}
