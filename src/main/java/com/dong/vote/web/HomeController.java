package com.dong.vote.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by dongxiaohua on 2017-12-20 12:02.
 */
@Controller
class HomeController {
  //    @RequestMapping("/logout")
  //    def logout(RedirectAttributes r) {
  //        SecurityUtils.getSubject().logout()
  //        r.addFlashAttribute("message", "您已经安全退出")
  //        "redirect:/logout"
  //    }

  @RequestMapping("/unauthorized")
  String unauthorized() {
    return "/home/unauthorized";
  }

  @RequestMapping("/error")
  String error() {
    return "home/error";
  }

  @RequestMapping(value = {"/home", "/"})
  String home() {
    return "home/home";
  }

}
