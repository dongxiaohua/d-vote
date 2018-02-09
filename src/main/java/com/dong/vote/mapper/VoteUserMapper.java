package com.dong.vote.mapper;

import com.dong.vote.entity.VoteUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteUserMapper {

  /**
   * 根据ID查找user
   * @param id
   * @return
   */
  @Select("SELECT * FROM v_user WHERE id = ${id}")
  VoteUser findById(@Param("id") int id);

  /**
   * 创建用户
   * @param name
   * @param pwd
   * @param rights
   * @return
   */
  @Insert("INSERT INTO v_user(user_name,pass_word,rights) VALUES(#{userName},#{pwd},#{rights})")
  int insert(@Param("userName") String name, @Param("pwd") String pwd, @Param("rights") String rights);

}
