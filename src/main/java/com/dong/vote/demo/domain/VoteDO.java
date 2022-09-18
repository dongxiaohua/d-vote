package com.dong.vote.demo.domain;

import com.dong.vote.demo.base.ConfigDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author: dongxiaohua
 * @date: 2022-09-12 23:31:09
 */
@Data
@Table(name = "vote")
public class VoteDO extends ConfigDO {
  @Column(name = "vote_name")
  private String voteName;

  @Column(name = "past_time")
  private Data pastTime;
}
