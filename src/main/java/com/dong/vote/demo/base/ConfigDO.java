package com.dong.vote.demo.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * @author: dongxiaohua
 * @date: 2022-09-17 13:50:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConfigDO extends BaseDO {

  @Column(name = "is_delete")
  private Boolean isDelete;

  @Column(name = "status")
  private String status;
}
