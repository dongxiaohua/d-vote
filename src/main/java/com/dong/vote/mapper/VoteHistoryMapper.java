package com.dong.vote.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteHistoryMapper {

  @Insert("INSERT INTO v_history(v_id,v_name,created_time,past_time) VALUES(#{vId},#{vName},now(),now())")
  int insert(@Param("vId") int vId, @Param("vName") String vName);

}
