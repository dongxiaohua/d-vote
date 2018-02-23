package com.dong.vote.service.impl;

import com.dong.vote.entity.Vote;
import com.dong.vote.entity.VoteHistory;
import com.dong.vote.entity.VoteOption;
import com.dong.vote.mapper.VoteHistoryMapper;
import com.dong.vote.mapper.VoteMapper;
import com.dong.vote.mapper.VoteOptionMapper;
import com.dong.vote.service.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
  @Autowired
  private VoteHistoryMapper voteHistoryMapper;


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
      vote.setOptionList(optionList);
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
      Vote vote = voteMapper.findVoteById(voteId);
      List<VoteOption> optionList = voteOptionMapper.findOptionByVoteId(voteId);
      sortIntMethod(optionList);
      VoteOption option = optionList.get(0);
      VoteHistory voteHistory = VoteHistory.builder()
                                           .voteId(voteId)
                                           .voteName(vote.getVoteName())
                                           .maxOption(option.getOptionName())
                                           .maxPoll(option.getOptionPoll())
                                           .voteCreatedTime(vote.getCreatedTime())
                                           .pastTime(vote.getPastTime())
                                           .build();
      voteHistoryMapper.insert(voteHistory);
      if (voteMapper.deleteById(voteId) == 1) {
        log.info("成功删除投票");
        if (optionList.size() > 0) {
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

  /**
   * 修改投票及选项
   *
   * @param vote
   */
  @Override
  public int updateVote(Vote vote) {
    int i = 0;
    try {
      if (voteMapper.updateVote(vote) == 1) {
        List<String> optionNames = vote.getOptionNameList();
        List<VoteOption> optionList = voteOptionMapper.findOptionByVoteId(vote.getId());
        for (int num = 0; num < optionList.size(); i++) {
          optionList.get(num).setOptionName(optionNames.get(num));
         i = voteOptionMapper.updateOptions(optionList.get(num));
        }
      }

    } catch (Exception e) {
      log.error("修改失败", e);
    }
    return i;
  }

  /**
   * 将optionList 按照票数多少排序（升序）
   *
   * @param list
   */
  @SuppressWarnings("unchecked")
  private static void sortIntMethod(List list) {
    Collections.sort(list, (o1, o2) -> {
      VoteOption hits1 = (VoteOption) o1;
      VoteOption hits2 = (VoteOption) o2;
      if (hits1.getOptionPoll() > hits2.getOptionPoll()) {
        return 1;
      } else if (hits1.getOptionPoll() == hits2.getOptionPoll()) {
        return 0;
      } else {
        return -1;
      }
    });
  }


}
