package com.dong.vote.study.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程测试
 * CompletableFuture 需要注意的是，只能保证独立线程结果在本线程的正确性，如果想要获取所有线程结果，main线程是获取不到的，除非监听
 *
 * @author dongxiaohua
 */
@Service
@Slf4j
public class ThreadDemoService {


  public Integer start(List<RunTaskModule> modules) {
    ExecutorService executor = new ThreadPoolExecutor(0, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20), new ThreadFactoryBuilder()
      .setNameFormat("dong-demo-%d")
      .build());
    AtomicInteger args = new AtomicInteger(0);
    modules.forEach(module -> {
      CompletableFuture
        .supplyAsync(new WaitTaskResult(RunTaskModule.builder().name(module.getName()).arg(module.getArg()).build()), executor)
        .whenComplete((result, e) -> {
          //执行线程完成后的操作
          System.out.println("线程名：" + Thread.currentThread().getName() + "结果：" + result);
          args.getAndAdd(result);
        })
        .exceptionally((e) -> {
          //抛出异常
          System.out.println(Thread.currentThread().getName() + "exception " + e);
          return 0;
        });
    });

    return args.get();
  }
}
