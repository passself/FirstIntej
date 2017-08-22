package com.cn.passself.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shx on 2017/5/11.
 */
public class CountDownTest {

    public static void main(String[] args){
        CountDownLatch mainLatch = new CountDownLatch(1);
        CountDownLatch waitLatch = new CountDownLatch(3);

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 "+Thread.currentThread().getName() + " 正准备接受命令");
                    try {
                        mainLatch.await();
                        System.out.println("线程 "+Thread.currentThread().getName() + " 已经接收到命令");
                        Thread.sleep((long)(Math.random()*1000));
                        System.out.println("线程 "+Thread.currentThread().getName() + " 回应命令处理结果");
                        waitLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }

        try {
            Thread.sleep((long)(Math.random()*3000));
            System.out.println("线程 "+Thread.currentThread().getName() + " 即将发布命令");
            mainLatch.countDown();
            System.out.println("线程 "+Thread.currentThread().getName() + " 已经发布命令");
            waitLatch.await();
            System.out.println("线程 "+Thread.currentThread().getName() + " 已经收到所有命令");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
