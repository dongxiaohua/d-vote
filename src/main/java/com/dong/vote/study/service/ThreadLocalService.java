package com.dong.vote.study.service;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: dongxiaohua
 * @date: 2023-03-31 17:04:22
 */
public class ThreadLocalService {

  private static final ReferenceQueue<Object> QUEUE = new ReferenceQueue<>();
  private static final LinkedList<byte[]> LIST = new LinkedList<>();

  public static void main(String[] args) {
    List<String> list = new ArrayList<>(0);
    list.add("");
    tlTest();

    //    phantomTest();

    //    weakTest();

    //    softTest();
  }


  // ThreadLocal
  static void tlTest() {
    ThreadLocal<Object> tl = new ThreadLocal<>();

    new Thread(() -> {
      tl.set("A");
    }).start();

    new Thread(() -> {
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(tl.get());
    }).start();
  }

  // 虚引用
  static void phantomTest() {
    PhantomReference<Object> pr = new PhantomReference<>(new Object(), QUEUE);
    System.out.println(pr.get());
    new Thread(() -> {
      while (true) {
        LIST.add(new byte[1024 * 1024]);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(() -> {
      while (true) {
        Object o = QUEUE.poll();
        if (o != null) {
          System.out.println("虚引用需要gc");
        }
      }
    }).start();
  }

  // 弱引用
  static void weakTest() {
    WeakReference<Object> wr = new WeakReference<>(new Object());
    System.out.println(wr.get());
    System.gc();
    System.out.println(wr.get());
  }


  // 软引用
  static void softTest() {
    SoftReference<byte[]> sr = new SoftReference<>(new byte[1024 * 1024 * 5]);

    System.out.println(sr.get());

    System.gc();

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    byte[] b = new byte[1024 * 1024 * 6];
    System.out.println(sr.get());
  }


}
