package com.cn.passself.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shihuaxian on 2018/2/6.
 * 手动实现锁
 */
public class MyLock {
    private AtomicInteger status = new AtomicInteger(0);

    public void lock(){
        while (!status.compareAndSet(0,1)){
            Thread.yield();
        }
    }

    public void unlock(){
        status.compareAndSet(1,0);
    }
}
