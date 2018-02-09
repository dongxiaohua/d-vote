package com.dong.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 选项表
 *
 * @author dongxiaohua
 * @date 2017/12/29
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteOption {
  private int id;
  private String optionName;
  private int voteId;
  private int optionPoll;
  private Date createdTime;
  private Date modifyTime;
}
