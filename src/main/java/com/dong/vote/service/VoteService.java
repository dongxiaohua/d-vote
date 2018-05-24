package com.dong.vote.service;

import com.dong.vote.entity.Vote;

import java.util.List;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteService {

  /**
   * 批量插入
   *
   * @param voteList 投票列表
   * @return
   */
  int batchInsert(List<Vote> voteList);

  /**
   * 插入投票
   *
   * @param vote
   * @return
   */
  int insert(Vote vote);

  /**
   * 根据投票ID查询投票的详细信息（包括选项）
   *
   * @param voteId 投票ID
   * @return
   */
  Vote findVoteAndOptionByVoteId(Integer voteId);

  /**
   * 根据投票ID删除投票及其选项
   *
   * @param voteId 投票ID
   * @return
   */
  int deleteVote(Integer voteId);

  /**
   * 修改投票及选项
   *
   * @param vote
   * @return
   */
  int updateVote(Vote vote);

}
