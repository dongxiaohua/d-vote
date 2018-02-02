package com.dong.vote.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteOptionMapper {

  @Insert("INSERT INTO v_option(o_name,v_id,o_poll,created_time,modify_time) VALUES(#{oName},#{vId},#{oPoll},now(),now())")
  int insert(@Param("oName") String oName, @Param("vId") int vId, @Param("oPoll") int oPoll);

}
