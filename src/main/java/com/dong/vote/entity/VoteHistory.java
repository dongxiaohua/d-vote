package com.dong.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *  历史表
 * @author dongxiaohua
 * @date 2017/12/29
 */
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteHistory {
  private int id;
  private int vNum;
  private String vName;
  private Date createdTime;
  private Date pastTime;
}
