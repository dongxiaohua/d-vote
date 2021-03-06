package com.dong.vote.mapper;

import com.dong.vote.entity.VoteUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteUserMapper {

  /**
   * 根据ID查找user
   *
   * @param id
   * @return
   */
  @Select("SELECT * FROM v_user WHERE id = #{id}")
  VoteUser findById(@Param("id") int id);

  /**
   * 根据名称查用户
   *
   * @param userName
   * @return
   */
  @Select("SELECT * FROM v_user WHERE user_name = #{userName}")
  VoteUser findByName(@Param("userName") String userName);

  /**
   * 创建用户
   *
   * @param name
   * @param pwd
   * @param rights
   * @return
   */
  @Insert("INSERT INTO v_user(user_name,pass_word,rights) VALUES(#{userName},#{pwd},#{rights})")
  int insert(@Param("userName") String name, @Param("pwd") String pwd, @Param("rights") String rights);

  /**
   * 检查userName
   *
   * @param userName
   * @return
   */
  @Select("SELECT count(*) FROM v_user WHERE user_name = #{userName}")
  int checkUserName(@Param("userName") String userName);

  /**
   * 更改用户投票时间
   *
   * @return
   */
  @Update("UPDATE v_user SET vote_time = #{user.voteTime},vote_ids = #{user.voteIds},today_vote_ids = #{user.todayVoteIds} WHERE id = #{user.id}")
  void updateVoteTime(@Param("user") VoteUser voteUser);

  /**
   * 验证用户用密码是否正确
   *
   * @param voteUser
   * @return
   */
  VoteUser findUserByNameAndPwd(VoteUser voteUser);

  /**
   * 将所有用户今天所涉及的投票设为null todo
   */
  @Update("UPDATE v_user SET today_vote_ids = null")
  void updateTodayVoteIds();


}
