package com.cn.passself.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by shihuaxian on 2017/4/28.
 */
public class CacheDemo {
    Map<String, Object> caches = new HashMap<String, Object>();

    public static void main(String[] args) {

    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object getData(String key) {
        rwl.readLock().lock();

        Object value = null;
        try {
            value = caches.get(key);
            if (value == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    if (value == null) {//要双重判断，因为当第一个线程写了之后，其他等待写的线程要先判断是否为null才不至于再次写入
                        value = "aaa" + key;
                    }
                } finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        } finally {
            rwl.readLock().unlock();
        }
        return value;
    }
}
