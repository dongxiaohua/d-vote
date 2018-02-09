package com.dong.vote.web;

import com.dong.vote.entity.VoteHistory;
import com.dong.vote.mapper.VoteHistoryMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author dongxiaohua
 *         Created on 2018/2/9.
 */
@Controller
@Slf4j
@RequestMapping("/history")
public class HistoryController {

  @Autowired
  private VoteHistoryMapper voteHistoryMapper;

  /**
   * 历史列表
   *
   * @return
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list() {
    return "history/list";
  }

  /**
   * 历史列表请求数据
   *
   * @return
   */
  @RequestMapping(value = "/history-rest")
  @ResponseBody
  public Map historyRest() {
    List<VoteHistory> list = voteHistoryMapper.findAllHistory();
    Map<String, List<Object>> map = Maps.newLinkedHashMap();
    List<Object> json = Lists.newArrayList();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    list.forEach(voteHistory -> {
      List<Object> data = Lists.newArrayList();
      data.add(String.valueOf(voteHistory.getId()));
      data.add(String.valueOf(voteHistory.getVoteId()));
      data.add(voteHistory.getVoteName());
      data.add(fmt.format(voteHistory.getPastTime()));
      data.add(String.valueOf(voteHistory.getId()));
      json.add(data);
    });
    map.put("data", json);
    return map;
  }

}
