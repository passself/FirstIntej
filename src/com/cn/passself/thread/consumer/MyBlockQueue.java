package com.cn.passself.thread.consumer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by shihuaxian on 2018/1/3.
 */
public class MyBlockQueue<E> {

    private Queue<E> queue = null;

    private int limit;

    public MyBlockQueue(int limit){
        this.limit = limit;
        queue = new ArrayDeque<E>();
    }

    public synchronized void put(E e) throws InterruptedException{
        while (queue.size() == limit){
            wait();
        }
        queue.add(e);
        notifyAll();
    }

    public synchronized E take() throws InterruptedException{
        while (queue.isEmpty()){
            wait();
        }
        E e = queue.poll();
        notifyAll();
        return e;
    }

    public int size(){
        return queue.size();
    }

    public static void main(String[] args) {
        SelfBlockQueue<String> queue = new SelfBlockQueue<>(10);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        producer.start();
        consumer.start();
    }
}
