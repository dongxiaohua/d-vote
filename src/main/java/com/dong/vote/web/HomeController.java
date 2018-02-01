package com.dong.vote.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dongxiaohua
 *         Created on 2017-12-20 12:02.
 */
@Controller
@Slf4j
class HomeController {
  //    @RequestMapping("/logout")
  //    def logout(RedirectAttributes r) {
  //        SecurityUtils.getSubject().logout()
  //        r.addFlashAttribute("message", "您已经安全退出")
  //        "redirect:/logout"
  //    }

  @RequestMapping("/unauthorized")
  public String unauthorized() {
    return "/home/unauthorized";
  }

  @RequestMapping("/error")
  public String error() {
    return "home/error";
  }

  @RequestMapping(value = {"/home", "/"})
  public String home() {
    return "home/home";
  }

}
