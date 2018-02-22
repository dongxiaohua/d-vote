package com.dong.vote.web;

import com.dong.vote.entity.Vote;
import com.dong.vote.entity.VoteOption;
import com.dong.vote.mapper.VoteMapper;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author dongxiaohua
 *         Created on 2018/2/1.
 */
@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private VoteMapper voteMapper;


  /**
   * 跳转列表
   *
   * @return
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list() {
    return "admin/list";
  }

  /**
   * 列表请求数据
   *
   * @return
   */
  @RequestMapping(value = "/admin-rest")
  @ResponseBody
  public Map adminRest() {
    List<Vote> list = voteMapper.findAll();
    Map<String, List<Object>> map = Maps.newLinkedHashMap();
    List<Object> json = Lists.newArrayList();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    list.forEach(vote -> {
      List<Object> data = Lists.newArrayList();
      data.add(String.valueOf(vote.getId()));
      data.add(vote.getVoteName());
      data.add(vote.getStatus());
      data.add(fmt.format(vote.getPastTime()));
      data.add(fmt.format(vote.getCreatedTime()));
      data.add(String.valueOf(vote.getId()));
      json.add(data);
    });
    map.put("data", json);
    return map;
  }

  /**
   * 跳转添加
   *
   * @param model
   * @return
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String addGet(Model model) {

    return "admin/add";
  }

  /**
   * 添加投票
   *
   * @return
   */
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String add(@RequestParam String voteName, @RequestParam String pastTime, @RequestParam String options, RedirectAttributes r) {
    try {
      SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
      Date pastTimes = dtf.parse(pastTime);
      Vote vote = Vote.builder().voteName(voteName).status("initiate").pastTime(pastTimes).build();
      //todo 插入投票并返回id
      int voteId = 1;
      List<String> optionNames = Splitter.on(CharMatcher.anyOf(",\n\t")).trimResults().omitEmptyStrings().splitToList(options);
      List<VoteOption> optionList = Lists.newArrayList();
      optionNames.forEach(optionName -> {
        optionList.add(VoteOption.builder().optionName(optionName).voteId(voteId).optionPoll(0).build());
      });
      return "admin/list";
    } catch (Exception e) {
      log.error("创建投票失败");
      r.addFlashAttribute("error", "创建投票失败");
      return "redirect:/admin/add";
    }
  }

  /**
   * 跳转编辑
   *
   * @return
   */
  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public String editGet(@RequestParam int voteId, Model model) {

    return "admin/edit";
  }

  /**
   * 编辑
   *
   * @return
   */
  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public String edit() {

    return "";
  }

}
