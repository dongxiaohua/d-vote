package com.dong.vote.mapperTest

import com.dong.vote.entity.Vote
import com.dong.vote.mapper.VoteMapper
import com.google.common.collect.Lists
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * @author dongxiaohua
 * Created on 2018/2/2.
 */
@ContextConfiguration(locations = ["classpath:mapperContext.xml"])
@Slf4j
class VoteMapperTest extends Specification {

  @Autowired
  VoteMapper voteMapper

  def "insert-test"() {
    given:
    def voteName = "时间测试"
    def status = "initiate"
    expect:
    println "============" + voteMapper.insert(voteName, status)
  }

  def "findAll-test"() {
    expect:
    println "==============" + voteMapper.findAll()
  }

  def "update-test"() {
    given:
    def voteId = 4
    def status = "outmoded"
    expect:
    voteMapper.update(voteId, status)
    println "============" + voteMapper.findVoteById(1).createdTime
  }

  def "batchInsert-test"() {
    given:
    def vote = new Vote()
    vote.setStatus("initiate")
    vote.setVoteName("测试批量创建接口")
    def voteList = Lists.newArrayList()
    voteList.add(vote)
    expect:
    println "===========" + voteMapper.batchInsert(voteList)

  }

}
