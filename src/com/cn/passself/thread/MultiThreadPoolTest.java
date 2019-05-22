package com.cn.passself.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiThreadPoolTest {


    public static void main(String[] args) {
        ExecutorService serviceSingle = Executors.newSingleThreadExecutor();
        ExecutorService serviceFixed = Executors.newFixedThreadPool(2);
        ExecutorService cacheService = Executors.newCachedThreadPool();

        Thread single1 = new MyThread();
        Thread single2 = new MyThread();
        Thread single3 = new MyThread();
        Thread single4 = new MyThread();
        Thread single5 = new MyThread();

        /*serviceSingle.execute(single1);
        serviceSingle.execute(single2);
        serviceSingle.execute(single3);
        serviceSingle.execute(single4);
        serviceSingle.execute(single5);
        serviceSingle.shutdown();

        serviceFixed.execute(single1);
        serviceFixed.execute(single2);
        serviceFixed.execute(single3);
        serviceFixed.execute(single4);
        serviceFixed.execute(single5);
        serviceFixed.shutdown();

        cacheService.execute(single1);
        cacheService.execute(single2);
        cacheService.execute(single3);
        cacheService.execute(single4);
        cacheService.execute(single5);
        cacheService.shutdown();*/

        ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("===================");
            }
        },1000,5000, TimeUnit.MILLISECONDS);

        scheduledExecutor.scheduleAtFixedRate(() ->
                System.out.println(System.nanoTime()),1000,2000,TimeUnit.MILLISECONDS);
    }
}
