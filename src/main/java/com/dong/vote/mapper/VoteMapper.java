package com.dong.vote.mapper;

import com.dong.vote.entity.Vote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteMapper {

  @Select("SELECT * FROM v_vote")
  List<Vote> findAll();

  @Select("SELECT * FROM v_vote WHERE id = #{id}")
  Vote findVoteById(@Param("id") int id);

  @Insert("INSERT INTO v_vote(v_name,status,created_time,modify_time) VALUES(#{vName},#{status},now(),now())")
  int insert(@Param("vName") String vName, @Param("status") String status);

}
