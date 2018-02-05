package com.dong.vote.web;

import com.dong.vote.entity.Vote;
import com.dong.vote.entity.VoteOption;
import com.dong.vote.mapper.VoteMapper;
import com.dong.vote.mapper.VoteOptionMapper;
import com.dong.vote.service.VoteOptionService;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
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
      data.add(vote.getVName());
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
  public String voting(@RequestParam int id, Model model) {
    Vote vote = voteMapper.findVoteById(id);
    List<VoteOption> optionList = voteOptionMapper.findOptionByVid(id);
    model.addAttribute("vote", vote);
    model.addAttribute("optionList", optionList);
    return "vote/voting";
  }

  /**
   * 参与投票
   *
   * @return
   */
  @RequestMapping(value = "/voting", method = RequestMethod.POST)
  public String votingPost(@RequestParam int optionId, @RequestParam String otherOption, @RequestParam int voteId, RedirectAttributes r) {
      if (voteOptionMapper.checkIn(otherOption,voteId) != 0) {
        r.addFlashAttribute("error","此选项名称已存在");
        return "redirect:/v/voting?id=" + voteId;
      }
    try {
      if (Strings.isNullOrEmpty(otherOption)) {
        voteOptionMapper.updateOption(optionId);
        log.info("投票成功");
        r.addFlashAttribute("success", "投票成功");
      } else {
        VoteOption voteOption = VoteOption.builder().optionName(otherOption).vId(voteId).build();
        optionService.insertOption(voteOption);
        log.info("投票成功");
        r.addFlashAttribute("success", "投票成功");
      }
    } catch (Exception e) {
      log.error("投票失败", e);
      r.addFlashAttribute("error", "投票失败，请稍后重试");
    }
    return "redirect:/v/voting?id=" + voteId;
  }


}
