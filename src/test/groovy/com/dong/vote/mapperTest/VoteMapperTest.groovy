package com.dong.vote.mapperTest

import com.dong.vote.mapper.VoteMapper
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
    def vName = "中华人民共和国"
    expect:
    println "============" + voteMapper.insert(vName)
  }

  def "findAll-test"() {
    expect:
    println "==============" + voteMapper.findAll()
  }

}
