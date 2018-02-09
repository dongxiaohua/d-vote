package com.dong.vote.service;

import com.dong.vote.entity.VoteOption;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteOptionService {

  /**
   * 插入新选项
   * @param voteOption
   * @return
   */
  int insertOption(VoteOption voteOption);

}
