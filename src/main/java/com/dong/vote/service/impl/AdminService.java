package com.dong.vote.service.impl;

import com.dong.vote.entity.VoteUser;
import com.dong.vote.mapper.VoteUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dongxiaohua
 * Created on 2018/6/5.
 */
@Service
@Slf4j
public class AdminService {

  @Autowired
  private VoteUserMapper voteUserMapper;


  /**
   * 检测当前用户权限
   *
   * @return
   */
  public boolean checkUserRights(String userId) {
    VoteUser user = voteUserMapper.findById(Integer.valueOf(userId));
    if ("admin".equals(user.getRights())) {
      return true;
    }
    return false;
  }




}
