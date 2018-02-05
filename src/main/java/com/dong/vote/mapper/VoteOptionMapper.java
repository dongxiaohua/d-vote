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

  @Insert("INSERT INTO v_option(option_name,vote_id,option_poll,created_time,modify_time) VALUES(#{optionName},#{voteId},#{optionPoll},now(),now())")
  int insert(@Param("optionName") String optionName, @Param("voteId") int voteId, @Param("optionPoll") int optionPoll);

  @Select("SELECT * FROM v_option WHERE vote_id = #{voteId}")
  List<VoteOption> findOptionByVoteId(@Param("voteId") int voteId);

  @Update("UPDATE v_option SET option_poll = option_poll+1, modify_time = now() WHERE id = #{id}")
  int updateOption(@Param("id") int id);

  @Select("SELECT count(*) FROM vote_option WHERE option_name = #{optionName} AND vote_id = #{voteId}")
  int checkIn(@Param("optionName") String oName,@Param("voteId") int voteId);

}
