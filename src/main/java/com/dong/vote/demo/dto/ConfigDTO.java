package com.dong.vote.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: dongxiaohua
 * @date: 2022-09-17 13:59:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConfigDTO extends BaseDTO {

  private Boolean isDelete;

  private String status;
}
