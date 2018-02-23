package com.dong.vote.mapper;

import com.dong.vote.entity.VoteHistory;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteHistoryMapper {

  /**
   * 插入历史
   * @param voteHistory
   * @return
   */
  int insert(VoteHistory voteHistory);

  /**
   * 查询所有历史
   *
   * @return
   */
  @Select("SELECT * FROM v_history")
  List<VoteHistory> findAllHistory();

}
