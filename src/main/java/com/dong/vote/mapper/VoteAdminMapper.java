package com.dong.vote.mapper;

import com.dong.vote.entity.Vote;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by dongxiaohua on 2017/12/1.
 */
public interface VoteAdminMapper {

  @Select("SELECT v_name FROM v_vote WHERE id = ${id}")
  String findById(@Param("id")int id);

  @Select("SELECT * FROM v_vote")
  List<Vote> findAll();
}
