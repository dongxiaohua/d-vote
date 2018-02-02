package com.dong.vote.mapperTest

import com.dong.vote.mapper.VoteOptionMapper
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
class VoteOptionMapperTest extends Specification {
  @Autowired
  VoteOptionMapper voteOptionMapper

  def "insert-test"() {
    given:
    def oName = "选项1"
    def vId = 2;
    def oPoll = 1341234
    expect:
    println "===========" + voteOptionMapper.insert(oName,vId,oPoll)
  }

}
