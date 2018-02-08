package com.dong.vote.mapper;

import com.dong.vote.entity.VoteOption;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteOptionMapper {

  /**
   * 插入新选项
   *
   * @param optionName 选项名称
   * @param voteId     投票ID
   * @param optionPoll 得票数
   * @return
   */
  @Insert("INSERT INTO v_option(option_name,vote_id,option_poll,created_time,modify_time) VALUES(#{optionName},#{voteId},#{optionPoll},now(),now())")
  int insert(@Param("optionName") String optionName, @Param("voteId") int voteId, @Param("optionPoll") int optionPoll);

  /**
   * 查询指定投票下的所有选项
   *
   * @param voteId 投票ID
   * @return
   */
  @Select("SELECT * FROM v_option WHERE vote_id = #{voteId}")
  List<VoteOption> findOptionByVoteId(@Param("voteId") int voteId);

  /**
   * 修改选项得票数
   *
   * @param id 选项id
   * @return
   */
  @Update("UPDATE v_option SET option_poll = option_poll+1, modify_time = now() WHERE id = #{id}")
  int updateOption(@Param("id") int id);

  /**
   * 检查是否存在此名称的选项
   *
   * @param optionName 选项名称
   * @param voteId     投票ID
   * @return
   */
  @Select("SELECT count(*) FROM vote_option WHERE option_name = #{optionName} AND vote_id = #{voteId}")
  int checkIn(@Param("optionName") String optionName, @Param("voteId") int voteId);

  /**
   * 查询投票的所有选项的得票数
   * @param voteId
   * @return
   */
  @Select("SELECT option_poll FROM v_option WHERE vote_id = #{voteId}")
  List<Integer> findOptionPollByVoteId(@Param("voteId") int voteId);

}
