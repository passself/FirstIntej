package com.cn.passself.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shihuaxian on 2018/2/22.
 * 显示锁实例
 * 显示条件和显示锁配合，wait/notify与synchronized配合
 *
 *
 * ReentrantLock实现了newCondition方法，通过它，来看下条件的基本用法
 */
public class ConditionWaitThread extends Thread{

    private volatile boolean fire = false;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    @Override
    public void run() {
        try {
            lock.lock();
            try {
                while (!fire){
                    System.out.println("await");
                    condition.await();
                }
            }finally {
                lock.unlock();
            }
            System.out.println("fired");
        }catch (InterruptedException e){
            Thread.interrupted();
        }
    }

    public void fire(){
        lock.lock();
        try {
            this.fire = true;
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionWaitThread waitThread = new ConditionWaitThread();
        waitThread.start();
        Thread.sleep(1000);
        System.out.println("fire");
        waitThread.fire();
    }
}
