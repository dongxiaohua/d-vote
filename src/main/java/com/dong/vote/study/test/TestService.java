package com.dong.vote.study.test;

import com.dong.vote.study.stramFifltsService.EmployPojo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
  public static void main(String[] args) {
    //    OverviewInfoScan overviewInfoScan = new CustomObjectScan();
    //    overviewInfoScan.scan();

    Test test = new Test();
    List<EmployPojo> pojos = Lists.newArrayList(EmployPojo.builder().name("1").build());
    List<List<EmployPojo>> p = test.getPartitionList(pojos);
    p.forEach(list -> {
      System.out.println(list);
    });

    List<String> st = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8");
    List<List<String>> sts = test.getPartitionList(st);
    System.out.println("");
  }
}


class Test {
  public <T> List<List<T>> getPartitionList(List<T> list) {
    List<List<T>> ptList = Lists.partition(list, 2);
    return ptList;
  }
}
