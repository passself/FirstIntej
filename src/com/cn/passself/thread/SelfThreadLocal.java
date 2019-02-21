package com.cn.passself.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义模拟一个ThreadLocal
 */
public class SelfThreadLocal<T> {

    Map<Thread,T> container = Collections.synchronizedMap(new HashMap<>());

    public void set(T value){
        container.put(Thread.currentThread(),value);
    }

    public T get(){
        Thread thread = Thread.currentThread();

        T value = container.get(thread);
        if (value == null && !container.containsKey(thread)){
            value = initValue();
            container.put(thread,value);
        }

        return value;
    }

    public void remove(){
        container.remove(Thread.currentThread());
    }

    protected T initValue(){
        return null;
    }
}
