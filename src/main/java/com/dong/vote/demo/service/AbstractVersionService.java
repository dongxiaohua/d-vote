package com.dong.vote.demo.service;

import com.dong.vote.demo.base.ConfigDO;
import com.dong.vote.demo.dto.ConfigDTO;
import com.dong.vote.demo.repository.AbstractConfigRepository;

/**
 * @author: dongxiaohua
 * @date: 2022-09-18 15:09:12
 */
public abstract class AbstractVersionService<DO extends ConfigDO, DTO extends ConfigDTO> extends AbstracrBaseService<DO, DTO> implements IVersionService {

  public AbstractVersionService(AbstractConfigRepository<DO> repository, String type) {
    super(repository, type);
  }
}
