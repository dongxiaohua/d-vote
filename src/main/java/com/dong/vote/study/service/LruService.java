package com.dong.vote.study.service;

/**
 * LRU算法
 *
 * @author: dongxiaohua
 * @date: 2023-03-25 17:20:50
 */
public class LruService {

  Entry head, tail;


  public static class Entry {
    public Entry pre;
    public Entry next;
    public int key;
    public int value;

    public Entry() {

    }

    public Entry(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}