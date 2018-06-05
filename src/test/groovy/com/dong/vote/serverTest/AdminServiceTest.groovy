package com.dong.vote.serverTest

import com.dong.vote.service.impl.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * @author dongxiaohua
 * Created on 2018/6/5.
 */
@ContextConfiguration(value = ["classpath:mapperContext.xml"])
class AdminServiceTest extends Specification {

  @Autowired
  AdminService adminService

  def "checkUserRightrs"() {
    given:
    def userId = "3"
    expect:
    println "============="
    println adminService.checkUserRights(userId)
  }
}
