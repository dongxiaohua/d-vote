package com.dong.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * v_vote 投票表
 *
 * @author dongxiaohua
 * @date 2017/12/1
 */
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
  private int id;
  private String voteName;
  private String status;
  private Date createdTime;
  private Date modifyTime;
}
