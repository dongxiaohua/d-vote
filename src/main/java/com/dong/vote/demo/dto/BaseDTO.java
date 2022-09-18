package com.dong.vote.demo.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: dongxiaohua
 * @date: 2022-09-17 13:57:49
 */
@Data
public class BaseDTO {

  /**
   * 主键
   */
  private Long id;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 修改时间
   */
  private Date modifiedTime;
}
