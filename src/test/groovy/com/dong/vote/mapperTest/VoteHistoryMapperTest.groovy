package com.dong.vote.mapperTest

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
    def voteId = 2
    def voteName = "投票名称"
    expect:
    println "============" + voteHistoryMapper.insert(voteId,voteName)
  }

}
