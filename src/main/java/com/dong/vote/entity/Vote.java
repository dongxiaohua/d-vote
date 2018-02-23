package com.dong.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * v_vote 投票表
 *
 * @author dongxiaohua
 * @date 2017/12/1
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
  private Integer id;
  private String voteName;
  private String status;
  private Date createdTime;
  private Date modifyTime;
  private Date pastTime;
  @Transient
  private List<String> optionNameList;
}
