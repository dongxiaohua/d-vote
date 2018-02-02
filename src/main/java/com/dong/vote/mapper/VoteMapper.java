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

  @Insert("INSERT INTO v_vote(v_name,created_time,modify_time) VALUES(#{vName},now(),now())")
  int insert(@Param("vName") String vName);
  
}
