package com.dong.vote.web;

import com.dong.vote.entity.Vote;
import com.dong.vote.mapper.VoteMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    List<Object> data = Lists.newArrayList();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for (Vote vote : list) {
      data.add(vote.getId());
      data.add(vote.getVName());
      data.add(vote.getStatus());
      data.add(fmt.format(vote.getCreatedTime()));
      data.add(String.valueOf(vote.getId()));
      json.add(data);
    }
    map.put("data", json);
    return map;
  }


}
