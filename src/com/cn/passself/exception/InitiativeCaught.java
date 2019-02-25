package com.cn.passself.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程捕获异常
 * 一种主动方法来解决未检测异常
 * 如果在线程池内部构建一个工作者线程，如果任务抛出了未检查异常，那么它将使线程终结，
 * 但会先通知框架该线程已经终结。然后框架可能会用新的线程来代替这个工作线程，也可能不会，因为线程池正在关闭，或者当前已经有足够多得线程
 * 满足需要。当编写一个向线程池提交任务的工作者类线程类时，或者调用不可信的外部代码时(例如动态加载的插件)，使用这些方法中的某一种
 * 可以避免某个编写得糟糕的任务或者插件不会影响调用它的线程
 */
public class InitiativeCaught {

    public void threadDeal(Runnable r,Throwable t){
        System.out.println("==Exception: "+t.getMessage());
    }

    class InitialtiveThread implements Runnable{
        @Override
        public void run() {
            Throwable thown = null;
            try {
                System.out.println(3/2);
                System.out.println(3/0);
                System.out.println(3/1);
            }catch (Exception e){
                thown = e;
            }finally {
                threadDeal(this,thown);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new InitiativeCaught().new InitialtiveThread());
        exec.shutdown();

        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();

        //如果采用线程池通过execute的方法去捕获异常，先看下面的例子
        /**
         * 只有通过execute提交的任务，才能将它抛出的异常交给UncaughtExceptionHandler，
         * 而通过submit提交的任务，无论是抛出的未检测异常还是已检查异常，都将被认为是任务返回状态的一部分。
         * 如果一个由submit提交的任务由于抛出了异常而结束，那么这个异常将被Future.get封装在ExecutionException中重新抛出。
         */
        ExecutorService exec2 = Executors.newCachedThreadPool();
        exec2.submit(new Task());
    }
}
/**
 * 在Thread Api中同样提供了UncaughtExceptionHandle,它能检测出某个由于未捕获的异常而终结的情况.
 *
 * 同样可以为所有的Thread设置一个默认的UncaughtExceptionHandler，
 * 通过调用Thread.setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)方法，
 * 这是Thread的一个static方法。
 */
class ExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("ExceptionHandler==Exception: "+e.getMessage());
    }
}


