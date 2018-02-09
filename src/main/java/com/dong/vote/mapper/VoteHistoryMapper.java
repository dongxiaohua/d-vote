package com.dong.vote.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteHistoryMapper {

  /**
   * 插入历史
   * @param voteId 投票Id
   * @param voteName 投票名称
   * @return
   */
  @Insert("INSERT INTO v_history(vote_id,vote_name,created_time,past_time) VALUES(#{voteId},#{voteName},now(),now())")
  int insert(@Param("voteId") int voteId, @Param("voteName") String voteName);

}
