package com.dong.vote.web;

import com.dong.vote.mapper.VoteUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by dongxiaohua on 2017/12/1.
 */
@Controller
@Slf4j
public class VoteAdminController {
  @Autowired
  private VoteUserMapper voteUserMapper;


}
