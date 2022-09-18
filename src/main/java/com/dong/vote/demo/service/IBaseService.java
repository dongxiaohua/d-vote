package com.dong.vote.demo.service;

import com.dong.vote.demo.dto.BaseDTO;
import com.dong.vote.demo.result.ServerResponse;

/**
 * @author: dongxiaohua
 * @date: 2022-09-18 14:48:54
 */
public interface IBaseService<DTO extends BaseDTO> {

  ServerResponse<DTO> execute(DTO dto);
}
