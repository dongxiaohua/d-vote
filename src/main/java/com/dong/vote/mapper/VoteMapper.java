package com.dong.vote.mapper;

import com.dong.vote.entity.Vote;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author dongxiaohua
 * @date 2017/12/29
 */
public interface VoteMapper {

  /**
   * 创建投票
   *
   * @param voteList
   * @return
   */
  int batchInsert(@Param("votes") List<Vote> voteList);


  /**
   * 根据投票id批量查询
   *
   * @param voteIds
   * @return
   */
  List<Vote> batchFindVoteByUser(@Param("voteIds") List<String> voteIds);

  /**
   * 查询所有投票
   *
   * @return
   */
  @Select("SELECT * FROM v_vote")
  List<Vote> findAll();

  /**
   * 根据ID查找投票
   *
   * @param id
   * @return
   */
  @Select("SELECT * FROM v_vote WHERE id = #{id}")
  Vote findVoteById(@Param("id") int id);

  /**
   * 创建投票
   *
   * @param vote
   * @return
   */
  int insert(Vote vote);

  /**
   * 根据ID查询投票名称
   *
   * @param voteId
   * @return
   */
  @Select("SELECT * FROM v_vote WHERE id=#{voteId}")
  Vote findVoteNameById(@Param("voteId") int voteId);

  /**
   * 修改投票状态
   *
   * @param voteId
   * @param status
   * @return
   */
  @Update("UPDATE v_vote SET status = #{status},modify_time = now() WHERE id = #{voteId}")
  int update(@Param("voteId") int voteId, @Param("status") String status);

  /**
   * 根据id删除
   *
   * @param id 投票ID
   * @return
   */
  @Delete("DELETE FROM v_vote WHERE id = #{id}")
  int deleteById(@Param("id") Integer id);

  /**
   * 修改投票
   *
   * @param vote
   * @return
   */
  int updateVote(Vote vote);

}
