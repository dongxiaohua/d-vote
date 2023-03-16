package com.dong.vote.serverTest

import com.dong.vote.study.service.AlgorithmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 *
 * 算法练习
 *
 * @author: dongxiaohua
 * @date: 2023-03-16 15:20:31 
 */
@ContextConfiguration(value = ["classpath:mapperContext.xml"])
class AlgorithmServiceTest extends Specification {

  @Autowired
  AlgorithmService algorithmService


  def "x的n次幂"() {
    expect:
    println "======="
    println algorithmService.powXn(2, 4)
    println algorithmService.powXn(3, 4)
    println algorithmService.powXn(3, -2)
  }
}
