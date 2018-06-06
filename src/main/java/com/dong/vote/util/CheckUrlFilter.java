package com.dong.vote.util;

import com.google.common.base.Strings;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * @author dongxiaohua
 * Created on 2018/6/5.
 */
public class CheckUrlFilter implements Filter {

  public FilterConfig config;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.config = filterConfig;
  }

  private boolean isContains(String container, String[] regx) {
    boolean result = false;

    for (int i = 0; i < regx.length; i++) {
      if (container.contains(regx[i])) {
        return true;
      }
    }
    return result;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest hrequest = (HttpServletRequest) request;
    HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);

    String logonStrings = config.getInitParameter("loginStrings");        // 登录登陆页面
    String includeStrings = config.getInitParameter("includeStrings");    // 过滤资源后缀参数
    String redirectPath = hrequest.getContextPath() + config.getInitParameter("redirectPath");// 没有登陆转向页面
    String disabletestfilter = config.getInitParameter("disableFilter");// 过滤器是否有效

    if (disabletestfilter.toUpperCase().equals("Y")) {    // 过滤无效
      chain.doFilter(request, response);
      return;
    }
    String[] loginList = logonStrings.split(";");
    String[] includeList = includeStrings.split(";");

    // 只对指定过滤参数后缀进行过滤
    if (this.isContains(hrequest.getRequestURI(), includeList)) {
      chain.doFilter(request, response);
      return;
    }
    // 对登录页面不进行过滤
    if (this.isContains(hrequest.getRequestURI(), loginList)) {
      chain.doFilter(request, response);
      return;
    }
    //判断用户是否登录
    String user = (String) hrequest.getSession().getAttribute("userName");
    if (Strings.isNullOrEmpty(user)) {
      wrapper.sendRedirect(redirectPath);
      return;
    } else {
      chain.doFilter(request, response);
      return;
    }
  }

  @Override
  public void destroy() {
    this.config = null;
  }
}
