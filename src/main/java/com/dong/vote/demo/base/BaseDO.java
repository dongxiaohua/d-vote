package com.dong.vote.demo.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: dongxiaohua
 * @date: 2022-09-17 13:42:18
 */
@Data
public class BaseDO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
  private Long id;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "modified_time")
  private Date modifiedTime;

}
