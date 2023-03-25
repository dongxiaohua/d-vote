package com.dong.vote.study.service;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * LRU算法
 *
 * 双向链表+map
 *
 * @author: dongxiaohua
 * @date: 2023-03-25 17:20:50
 */
public class LruCache {

  Entry head, tail;
  // 缓存容量
  int capacity;
  // 当前长度
  int size;

  Map<Integer,Entry> cache;

  public LruCache(int capacity){
    this.capacity = capacity;
    size = 0;
    cache = Maps.newHashMap();

    initLinkedList();
  }


  private void initLinkedList(){
    head = new Entry();
    tail = new Entry();

    head.next = tail;
    tail.pre = head;
  }


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