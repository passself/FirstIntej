package com.cn.passself.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shx on 17/4/1.
 * 线程池测试
 */
public class ThreadPoolTest {

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i <= 10; i++) {
            final int taskId = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(20);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    for (int j = 0; j <= 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " is looping of "+j+" for task of "+taskId);
                    }
                }
            });
        }
        System.out.println("all of 10 task have commited");
        threadPool.shutdown();

    }
}
