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
     * @param voteName
     * @param status
     * @return
     */
    @Insert("INSERT INTO v_vote(vote_name,status,created_time,modify_time) VALUES(#{voteName},#{status},now(),now())")
    int insert(@Param("voteName") String voteName, @Param("status") String status);

    /**
     * 根据ID查询投票名称
     *
     * @param voteId
     * @return
     */
    @Select("SELECT vote_name FROM v_vote WHERE id=#{voteId}")
    String findVoteNameById(@Param("voteId") int voteId);

}
