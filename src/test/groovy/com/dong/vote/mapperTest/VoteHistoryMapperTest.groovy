package com.dong.vote.mapperTest

import com.dong.vote.entity.VoteHistory
import com.dong.vote.mapper.VoteHistoryMapper
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * @author dongxiaohua
 *  Created on 2017-12-1.
 */
@ContextConfiguration(locations = "classpath:mapperContext.xml")
@Slf4j
class VoteHistoryMapperTest extends Specification {
  @Autowired
  VoteHistoryMapper voteHistoryMapper

  def "insert-test"() {
    given:
    def history = new VoteHistory()
    history.setVoteId(1)
    history.setVoteName("测试插入历史")
    history.setMaxOption("测试插入历史")
    history.setMaxPoll(100)
    history.setVoteCreatedTime(new Date())
    history.setPastTime(new Date())
    expect:
    println "============" + voteHistoryMapper.insert(history)
  }

}
