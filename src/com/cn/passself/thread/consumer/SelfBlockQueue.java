package com.cn.passself.thread.consumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by shihuaxian on 2018/1/3.
 */
public class SelfBlockQueue<E> {

    private ArrayBlockingQueue<E> queue = null;

    private int limit;

    public SelfBlockQueue(int limit){
        this.limit = limit;
        queue = new ArrayBlockingQueue<E>(limit);
    }

    public void put(E e) throws InterruptedException{
        while (queue.size() < limit){
            //wait();
            queue.add(e);
        }
        //notifyAll();
    }

    public E take() throws InterruptedException{
        while (!queue.isEmpty()){
            //wait();
            E e = queue.poll();
            return e;
        }
        //notifyAll();
        return null;
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
