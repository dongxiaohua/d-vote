package com.dong.vote.service.impl;

import com.dong.vote.entity.Vote;
import com.dong.vote.entity.VoteOption;
import com.dong.vote.mapper.VoteMapper;
import com.dong.vote.mapper.VoteOptionMapper;
import com.dong.vote.service.VoteService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
@Service
@Slf4j
public class VoteServiceImpl implements VoteService {
  @Autowired
  private VoteMapper voteMapper;
  @Autowired
  private VoteOptionMapper voteOptionMapper;


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

  /**
   * 插入投票并返回Id
   *
   * @param vote
   * @return
   */
  @Override
  public int insert(Vote vote) {
    voteMapper.insert(vote);
    return vote.getId();
  }

  /**
   * 根据投票ID查询投票详细信息
   *
   * @param voteId
   * @return
   */
  @Override
  public Vote findVoteAndOptionByVoteId(Integer voteId) {
    Vote vote = voteMapper.findVoteById(voteId);
    try {
      List<VoteOption> optionList = voteOptionMapper.findOptionByVoteId(voteId);
      List<String> optionNameList = Lists.newArrayList();
      optionList.forEach(option -> optionNameList.add(option.getOptionName()));
      vote.setOptionNameList(optionNameList);
      log.info("查询成功，voteId={}", voteId);
    } catch (Exception e) {
      log.error("查询失败，voteId={}", voteId, e);
    }
    return vote;
  }

  /**
   * 删除投票
   *
   * @param voteId 投票ID
   * @return
   */
  @Override
  public int deleteVote(Integer voteId) {
    int i = 1;
    try {
      if (voteMapper.deleteById(voteId) == 1) {
        if (voteOptionMapper.findOptionNumByVoteId(voteId) > 0) {
          i = voteOptionMapper.deleteByVoteId(voteId);
          log.info("删除成功，voteId={}", voteId);
        } else {
          log.info("无对应选项，voteId={}", voteId);
          return i;
        }
      }
    } catch (Exception e) {
      log.info("删除失败，voteId={}", voteId, e);
    }
    return i;
  }


}
