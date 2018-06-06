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
    def vote = new Vote()
    vote.voteName = "测试新插入"
    vote.status = "initiate"
    vote.pastTime = new Date()
    expect:
    println "============" + voteMapper.insert(vote)
    println(vote.id)
  }

  def "findAll-test"() {
    expect:
    println "==============" + voteMapper.findAll()
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

  def "updateVote-test" () {
    given:
    def vote = new Vote()
    vote.setPastTime(new Date())
    vote.setVoteName("测试修改")
    vote.setId(15)
    vote.setStatus("terminate")
    expect:
    println "===========" + voteMapper.updateVote(vote)
  }

  def "batchFindVoteByUser"() {
    given:
    def list = ['3','21']
    expect:
    println "============"
    println voteMapper.batchFindVoteByUser(list)
  }

}
