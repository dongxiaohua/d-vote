package com.dong.vote.mapperTest

import com.dong.vote.mapper.VoteUserMapper
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
class VoteAdminMapperTest extends Specification {
  @Autowired
  VoteUserMapper voteUserMapper

  def "findUserById-mapper"() {
    given:
    def id = 1
    expect:
    println "=========" + voteUserMapper.findById(id).userName

  }


}
