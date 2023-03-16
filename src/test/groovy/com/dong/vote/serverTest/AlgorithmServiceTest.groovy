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

  def "滑动窗口"() {
    expect:
    println "========"
    println algorithmService.slidingWindow([1, 2, 2, 4, 5, 5, 2] as int[], 2)
  }

  def "最长不重复子串" () {
    given:
    int[] nums = [1, 2, 3, 3, 4]
    expect:
    println "========="
    println algorithmService.maxLength(nums)
  }


  def "IPv4" () {
    given:
    String ipv4 = "172.17.23.4"
    expect:
    println "======="
    println algorithmService.IPv4(ipv4)
  }
}
