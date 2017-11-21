package com.cn.passself.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by shihuaxian on 2017/5/7.
 */
public class SemaphereTest {

    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();

        final Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程 "+Thread.currentThread().getName()+" 进入 ,当前已有"+(3-sp.availablePermits())+"个并发");

                    try {
                        Thread.sleep((long)Math.random()*1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程 "+Thread.currentThread().getName() + "即将离开");
                    sp.release();

                    System.out.println("线程 "+Thread.currentThread().getName()+" 已经离开 ,当前已有"+(3-sp.availablePermits())+"个并发");
                }
            };
            service.execute(runnable);
        }
    }
}
