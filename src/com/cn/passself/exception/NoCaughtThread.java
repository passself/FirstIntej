package com.cn.passself.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 当单线程的程序发生一个异常时我们没有采用try...catch 来捕获异常
 * 但是在多线程环境中，线程抛出异常是不能try..catch捕获的，这样有可能导致一些问题,
 * 比如异常的时候无法回收一些系统资源，或者没有关闭一些链接
 */
public class NoCaughtThread {

    public static void main(String[] args) {
        //1. 单线程捕获
        try {
            Thread thread = new Thread(new Task());
            thread.start();
        }catch (Exception e){
            System.out.println("==Exception: "+e.getMessage());
        }

        //2. 多线程无法捕获 原因:Thread 的run方法是不抛出任何检查类型异常的，但是它自身却可能因为一个异常而被终止。导致这个线程的终结。
        // 怎样捕获见InitiativeCaught class
        /*try {
            ExecutorService service = Executors.newFixedThreadPool(3);
            service.submit(new Task());
            service.submit(new Task());
            service.submit(new Task());
        }catch (Exception e){
            System.out.println("==Exception: "+e.getMessage());
        }*/
    }
}

class Task implements Runnable{
    @Override
    public void run() {
        System.out.println(3/2);
        System.out.println(3/0);
        System.out.println(3/1);
    }
}
