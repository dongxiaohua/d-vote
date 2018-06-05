package com.dong.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户表
 *
 * @author dongxiaohua
 * @date 2017/12/29
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteUser {
  private int id;
  private String userName;
  private String passWord;
  private Date voteTime;
  private String rights;
  private String voteIds;
  private String todayVoteIds;
}
