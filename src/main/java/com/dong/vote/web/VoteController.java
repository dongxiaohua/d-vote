package com.dong.vote.web;

import com.dong.vote.entity.Vote;
import com.dong.vote.entity.VoteOption;
import com.dong.vote.mapper.VoteMapper;
import com.dong.vote.mapper.VoteOptionMapper;
import com.dong.vote.service.VoteOptionService;
import com.dong.vote.service.VoteService;
import com.google.common.base.Strings;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author dongxiaohua
 * @date 2017/12/1
 */
@Controller
@Slf4j
@RequestMapping("/v")
public class VoteController {

  @Resource
  private VoteMapper voteMapper;
  @Resource
  private VoteOptionMapper voteOptionMapper;
  @Resource
  private VoteOptionService optionService;
  @Autowired
  private VoteService voteService;

  /**
   * 最新投票列表
   *
   * @return
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String voteList() {
    return "vote/list";
  }

  /**
   * 投票列表数据获取
   *
   * @return
   */
  @RequestMapping(value = "vote-rest")
  @ResponseBody
  public Map vote() {
    List<Vote> list = voteMapper.findAll();
    Map<String, List<Object>> map = Maps.newLinkedHashMap();
    List<Object> json = Lists.newArrayList();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    list.forEach(vote -> {
      List<Object> data = Lists.newArrayList();
      data.add(vote.getId());
      data.add(vote.getVoteName());
      data.add(vote.getStatus());
      data.add(fmt.format(vote.getCreatedTime()));
      data.add(String.valueOf(vote.getId()));
      json.add(data);
    });
    map.put("data", json);
    return map;
  }

  /**
   * 跳转参与投票
   *
   * @param id voteId
   * @return
   */
  @RequestMapping(value = "/voting", method = RequestMethod.GET)
  public String voting(@RequestParam int id, Model model, RedirectAttributes r) {
    Vote vote = voteMapper.findVoteById(id);
    if (vote == null) {
      r.addFlashAttribute("waring", "出现错误！投票不存在,id=" + id);
      return "redirect:/v/list";
    }
    List<VoteOption> optionList = voteOptionMapper.findOptionByVoteId(id);
    model.addAttribute("vote", vote);
    model.addAttribute("optionList", optionList);
    return "vote/voting";
  }

  /**
   * 参与投票
   *
   * @param optionId    选中选项的id
   * @param otherOption 添加的选项名称
   * @param voteId      投票Id
   * @param r
   * @return
   */
  @RequestMapping(value = "/voting", method = RequestMethod.POST)
  public String votingPost(@RequestParam int optionId, @RequestParam String otherOption, @RequestParam int voteId, RedirectAttributes r, HttpSession session) {
    if (Strings.isNullOrEmpty(otherOption) && optionId == 0) {
      r.addFlashAttribute("warning", "您没有做出选择");
      return "redirect:/v/voting?id=" + voteId;
    }

    Vote vote = voteMapper.findVoteById(voteId);
    if (!"initiate".equals(vote.getStatus())) {
      r.addFlashAttribute("error", "当前投票已关闭");
      return "redirect:/v/voting?id=" + voteId;
    }
    try {
      Integer userId = (Integer) session.getAttribute("userId");
      if (userId == null) {
        return "redirect:/lg/login";
      }
      if (voteService.checkUserToVote(userId, voteId)) {
        r.addFlashAttribute("warning", "您今天已经投过票了，请明天再投吧！");
        return "redirect:/v/voting?id=" + voteId;
      }
    } catch (Exception e) {
      log.error("检测当前用户是否投票异常，error:", e);
      r.addFlashAttribute("warning", "检测当前用户是否投票异常");
      return "redirect:/v/voting?id=" + voteId;
    }
    try {
      if (Strings.isNullOrEmpty(otherOption)) {
        voteOptionMapper.updateOption(optionId);
        log.info("投票成功");
        r.addFlashAttribute("success", "投票成功");
      } else {
        VoteOption voteOption = VoteOption.builder().optionName(otherOption).voteId(voteId).optionPoll(1).build();
        optionService.insertOption(voteOption);
        log.info("投票成功");
        r.addFlashAttribute("success", "投票成功");
      }
    } catch (Exception e) {
      log.error("投票失败", e);
      r.addFlashAttribute("error", "投票失败，请稍后重试");
    }
    //    重定向到详情页
    return "redirect:/v/detail?voteId=" + voteId;
  }

  /**
   * 指定投票详情页面
   *
   * @param voteId
   * @return
   */
  @RequestMapping(value = "/detail", method = RequestMethod.GET)
  public String detail(@RequestParam int voteId, Model model) {
    Vote vote = voteMapper.findVoteNameById(voteId);
    List<VoteOption> voteOptionList = voteOptionMapper.findOptionPollByVoteId(voteId);
    model.addAttribute("voteName", vote.getVoteName());
    model.addAttribute("voteId", vote.getId());
    model.addAttribute("voteOptionList", voteOptionList);
    return "vote/detail";
  }


  /**
   * 跳转用户投票历史
   *
   * @return
   */
  @RequestMapping("/history-list")
  public String historyList() {
    return "vote/history-list";
  }

  /**
   * 用户 投票历史列表
   *
   * @param session
   * @return
   */
  @RequestMapping(value = "/history-rest")
  @ResponseBody
  public Map historyRest(HttpSession session) {
    List<Vote> list = voteService.findVoteByUser((Integer) session.getAttribute("userId"));
    Map<String, List<Object>> map = Maps.newLinkedHashMap();
    List<Object> json = Lists.newArrayList();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    list.forEach(vote -> {
      List<Object> data = Lists.newArrayList();
      data.add(String.valueOf(vote.getId()));
      data.add(String.valueOf(vote.getVoteName()));
      data.add(fmt.format(vote.getPastTime()));
      data.add(String.valueOf(vote.getId()));
      json.add(data);
    });
    map.put("data", json);
    return map;
  }


}
