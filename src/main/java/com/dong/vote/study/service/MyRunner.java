package com.dong.vote.study.service;

/**
 * @author: dongxiaohua
 * @date: 2023-04-24 16:19:46
 */
public class MyRunner implements Runnable {
  @Override
  public void run() {
    System.out.println("run");
  }

  public void run(int value){
    System.out.println(value);
  }
}
