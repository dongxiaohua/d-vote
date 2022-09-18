package com.dong.vote.practice.consumer;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Consumer<> 接口demo
 *
 * @author dongxiaohua
 */
public class ConsumerInterfaceService {
  public static void demoInfo(List<String> names, Consumer<List> consumer) {
    //    names.forEach(name -> {
    //      consumer.accept(name + "demo");
    //    });

    consumer.accept(names);
  }

  public static void main(String[] args) {
    List<String> names = Lists.newArrayList("a1", "a2", "a3");

    Map<String, List> map = Maps.newHashMap();
    //v -> 回调函数，可以用来处理names
    demoInfo(names, v -> {
      map.put("1", v);
    });
    System.out.println(map);
  }
}
