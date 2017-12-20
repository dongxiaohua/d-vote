package com.dong.vote.mapperTest

import com.dong.vote.mapper.VoteAdminMapper
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by dongxiaohua on 2017-12-1.
 */
@ContextConfiguration(locations = "classpath:mapperContext.xml")
@Slf4j
class VoteAdminMapperTest extends Specification {
  @Autowired
  VoteAdminMapper voteAdminMapper

  def "findById-mapper" (){
    given:
    def id = 1
    expect:
    println "=========" + voteAdminMapper.findById(id)

  }

  def "finAll-mapper" () {
    expect:
    println "========" + voteAdminMapper.findAll()
  }


}
