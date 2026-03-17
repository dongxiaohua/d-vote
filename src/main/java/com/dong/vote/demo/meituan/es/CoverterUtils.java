package com.dong.vote.demo.meituan.es;

import freemarker.template.utility.NumberUtil;
import org.springframework.util.NumberUtils;

/**
 * @author: dongxiaohua
 * @date: 2026-03-07 22:56:50
 */
public class CoverterUtils {

  public static String cover2String(Object obj){
    if (obj == null) {
      return null;
    }

    return obj instanceof String ? (String) obj : obj.toString();
  }

  public static Long cover2Long(Object obj) {
    if (obj == null) {
      return null;
    }

    if (obj instanceof String) {
      return NumberUtils.parseNumber((String) obj, Long.class);
    }

    return obj instanceof Number ? Long.valueOf(obj.toString()) : null;
  }
}
