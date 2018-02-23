package com.cn.passself.thread.consumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shihuaxian on 2018/2/23.
 * 定义了两个等待的条件: 不满(notFull),不空(notEmpty),在put方法中，如果队列满，则在notFull等待，
 * 在take方法中，如果队列空，则在notEmpty等待，put 操作后通知notEmpty，take操作后通知notFull
 * 这样，代码更为清晰易读，同时避免了不必要的唤醒和检查，提高了效率。Java并发包中的类ArrayBlockingQueue就采用了类似的方式实现。
 */
public class MyBlockingQueue<E> {
    private Queue<E> queue = null;

    private int limit;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int limit){
        this.limit = limit;
        queue = new ArrayDeque<E>(limit);
    }

    public void put(E e) throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while (queue.size() == limit){
                notFull.await();
            }
            queue.add(e);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while (queue.isEmpty()){
                notEmpty.await();
            }
            E e = queue.poll();
            notFull.signal();
            return e;
        }finally {
            lock.unlock();
        }
    }
}
