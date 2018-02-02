package com.dong.vote.mapperTest

import com.dong.vote.mapper.VoteUserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * @author dongxiaohua
 * Created on 2018/2/2.
 */
@ContextConfiguration(locations = ["classpath:mapperContext.xml"])
class VoteUserMapperTest extends Specification {
  @Autowired
  VoteUserMapper voteUserMapper

  def "insert-test"() {
    given:
    def name = "名称"
    def pwd = "123"
    def rights = "user"
    expect:
    println "===========" + voteUserMapper.insert(name,pwd,rights)
  }

  def "findUserById-mapper"() {
    given:
    def id = 1
    expect:
    println "=========" + voteUserMapper.findById(id).userName

  }

}
