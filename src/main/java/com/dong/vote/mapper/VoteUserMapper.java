package com.dong.vote.mapper;

import com.dong.vote.entity.Vote;
import com.dong.vote.entity.VoteUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteUserMapper {
  @Select("SELECT * FROM v_user WHERE id = ${id}")
  VoteUser findById(@Param("id")int id);

}
