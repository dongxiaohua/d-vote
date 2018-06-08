package com.dong.vote.web;

import com.alibaba.fastjson.JSONObject;
import com.dong.vote.entity.VoteUser;
import com.dong.vote.mapper.VoteUserMapper;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author dongxiaohua
 * Created on 2018/2/24.
 */
@Controller
@Slf4j
@RequestMapping("/lg")
public class LoginController {

  @Autowired
  private VoteUserMapper voteUserMapper;

  /**
   * 跳转登录
   *
   * @return
   */
  @RequestMapping(value = "/login")
  public String loginGet() {
    return "home/login";
  }

  /**
   * 登录
   *
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@Valid VoteUser user, HttpSession session) {
    try {
      VoteUser voteUser = voteUserMapper.findUserByNameAndPwd(user);
      if (voteUser == null) {
        return "redirect:/lg/login";
      }
      session.setAttribute("userId", voteUser.getId());
      session.setAttribute("userName", voteUser.getUserName());
      return "redirect:/";
    } catch (Exception e) {
      log.error("登录失败", e);
      return "redirect:/lg/login";
    }
  }

  /**
   * 跳转注册
   *
   * @return
   */
  @RequestMapping(value = "/register")
  public String registerGet() {
    return "home/register";
  }

  /**
   * 注册
   *
   * @return
   */
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String register(@Valid VoteUser voteUser) {
    voteUserMapper.insert(voteUser.getUserName(), voteUser.getPassWord(), "user");
    return "redirect:/lg/login";
  }


  /**
   * 检查用户名是否存在
   *
   * @return
   */
  @RequestMapping(value = "/check", method = RequestMethod.POST)
  public String check(@RequestParam String userName) {
    int i = voteUserMapper.checkUserName(userName);
    Map<String, Boolean> map = Maps.newHashMap();
    if (i == 0) {
      map.put("valid", true);
      return JSONObject.toJSONString(map);
    } else {
      map.put("valid", false);
      return JSONObject.toJSONString(map);
    }
  }

}
