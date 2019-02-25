package com.cn.passself.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  只有通过execute提交的任务，才能将它抛出的异常交给UncaughtExceptionHandler，而通过submit提交的任务，
 *  无论是抛出的未检测异常还是已检测异常，都将被认为是任务返回的一部分。如果一个由submit提交任务由于抛出了
 *  异常而结束，那么这个异常将被Future.get封装在ExecutionException中重新抛出s
 */
public class SubmitCaught {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Task());
        service.shutdown();

        ExecutorService service2 = Executors.newCachedThreadPool();
        Future<?> future = service2.submit(new Task());
        service2.shutdown();
        try {
            future.get();
        }catch (Exception e){
            System.out.println("future==Exception: "+e.getMessage());
        }
    }
}

class ThreadPoolTask implements Runnable
{
    @Override
    public void run()
    {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        System.out.println(3/2);
        System.out.println(3/0);
        System.out.println(3/1);
    }
}
