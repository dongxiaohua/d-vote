package com.dong.vote.study.service;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;

import java.time.Instant;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * redis 实现延时队列
 *
 * @author: dongxiaohua
 * @date: 2023-03-22 01:01:59
 */
//@Service
public class RedisForProductConsumerService {

  private java.util.concurrent.ExecutorService executor = new ThreadPoolExecutor(0, 100, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadFactoryBuilder()
    .setNameFormat("-%d")
    .build());

  @Autowired
  private Jedis jedis;

  public void product() {
    executor.execute(() -> {
      // 利用zset添加一个1分钟后执行的任务
      jedis.zadd("delay_task", Instant.now().getEpochSecond() + 60,"value");
    });
  }

  public void consumer(){
    while (!Thread.interrupted()) {
      executor.execute(()->{
        Set<String> tasks = jedis.zrangeByScore("delay_task",0,Instant.now().getEpochSecond(),0,1);
        if (!CollectionUtils.isEmpty(tasks)) {
          String task = tasks.iterator().next();
          // 利用zrem限制并发
          Long success = jedis.zrem("delay_task",task);
          if (1 == success) {
            System.out.println("抢到消息去执行业务逻辑");
          } else {
            System.out.println("没有抢到消息");
          }
        }
      });
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
