package com.dong.vote.service.impl;

import com.dong.vote.entity.Vote;
import com.dong.vote.entity.VoteHistory;
import com.dong.vote.entity.VoteOption;
import com.dong.vote.entity.VoteUser;
import com.dong.vote.mapper.VoteHistoryMapper;
import com.dong.vote.mapper.VoteMapper;
import com.dong.vote.mapper.VoteOptionMapper;
import com.dong.vote.mapper.VoteUserMapper;
import com.dong.vote.service.VoteService;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
@Service
@Slf4j
public class VoteServiceImpl implements VoteService {

  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  @Autowired
  private VoteMapper voteMapper;
  @Autowired
  private VoteOptionMapper voteOptionMapper;
  @Autowired
  private VoteHistoryMapper voteHistoryMapper;
  @Autowired
  private VoteUserMapper voteUserMapper;


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
      VoteHistory voteHistory = VoteHistory
        .builder()
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
   * 检测当前用户是否投票
   * true代表今天已经投票
   *
   * @param userId
   * @return
   */
  @Override
  public boolean checkUserToVote(Integer userId, Integer voteId) {
    VoteUser user = voteUserMapper.findById(userId);

    String voteIds = filterVoteId(user, voteId);
    String todayVoteIds = todayVoteIds(user, voteId);

    if (checkUserTheOtherVote(user, voteId)) {
      user.setVoteTime(new Date());
      user.setVoteIds(voteIds);
      user.setTodayVoteIds(todayVoteIds);
      voteUserMapper.updateVoteTime(user);

      return true;
    }

    user.setVoteTime(new Date());
    user.setVoteIds(voteIds);
    user.setTodayVoteIds(todayVoteIds);
    voteUserMapper.updateVoteTime(user);
    return false;
  }

  /**
   * 判断当前用户当前投票是否投票
   *
   * @return
   */
  private boolean checkUserTheOtherVote(VoteUser user, Integer voteId) {
    String todayVoteIds = user.getTodayVoteIds();
    if ((sdf.format(new Date())).equals(sdf.format(user.getVoteTime()))) {
      if (user.getTodayVoteIds() != null) {
        if (todayVoteIds.contains(String.valueOf(voteId))) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 拼装用户涉及的投票
   *
   * @param user
   * @param voteId
   * @return
   */
  private String filterVoteId(VoteUser user, Integer voteId) {
    List<String> voteIds = Lists.newArrayList();
    if (user.getVoteIds() != null) {
      voteIds.addAll(Splitter.on(CharMatcher.anyOf(",\n\t")).trimResults().omitEmptyStrings().splitToList(user.getVoteIds()));
    }
    voteIds.add(String.valueOf(voteId));
    voteIds = new ArrayList<String>(new HashSet<String>(voteIds));
    return Joiner.on(",").join(voteIds);
  }

  /**
   * 拼装当前用户今天涉及的投票
   *
   * @return
   */
  private String todayVoteIds(VoteUser user, Integer voteId) {
    List<String> todatVoteIds = Lists.newArrayList();
    if (user.getTodayVoteIds() != null) {
      todatVoteIds.addAll(Splitter.on(CharMatcher.anyOf(",\n\t")).trimResults().omitEmptyStrings().splitToList(user.getTodayVoteIds()));
    }
    todatVoteIds.add(String.valueOf(voteId));
    todatVoteIds = new ArrayList<String>(new HashSet<String>(todatVoteIds));
    return Joiner.on(",").join(todatVoteIds);
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
