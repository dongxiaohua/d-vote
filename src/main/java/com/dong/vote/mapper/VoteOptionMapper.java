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

  @Insert("INSERT INTO v_option(o_name,v_id,o_poll,created_time,modify_time) VALUES(#{oName},#{vId},#{oPoll},now(),now())")
  int insert(@Param("oName") String oName, @Param("vId") int vId, @Param("oPoll") int oPoll);

  @Select("SELECT * FROM v_option WHERE v_id = #{vId}")
  List<VoteOption> findOptionByVid(@Param("vId") int vId);

  @Update("UPDATE v_option SET o_poll = o_poll+1, modify_time = now() WHERE id = #{id}")
  int updateOption(@Param("id") int id);

  @Select("SELECT count(*) FROM v_option WHERE o_name = #{oName} AND v_id = #{vId}")
  int checkIn(@Param("oName") String oName,@Param("vId") int vId);

}
