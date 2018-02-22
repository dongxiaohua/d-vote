package com.dong.vote.serverTest

import com.dong.vote.entity.Vote
import com.dong.vote.service.VoteService
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
class VoteServiceTest extends Specification {

  @Autowired
  VoteService voteService

  def "insert-test" () {
    given:
    def vote = new Vote()
    vote.setVoteName("测试插入")
    vote.setStatus("initiate")
    vote.setPastTime(new Date())
    expect:
    println "==========" + voteService.insert(vote)
  }

}
