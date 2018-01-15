package com.cn.passself.thread.consumer;

/**
 * Created by shihuaxian on 2018/1/3.
 */
public class Consumer extends Thread{

    SelfBlockQueue<String> queue;
    //MyBlockQueue<String> myQueue;

    public Consumer(SelfBlockQueue<String> queue){
        this.queue = queue;
    }

    /*public Consumer(MyBlockQueue<String> queue){
        this.myQueue = queue;
    }*/

    @Override
    public void run() {
        try {
            while (true) {
                String task = queue.take();
                System.out.println("consumer task is:"+task+"--queue.size() is:"+queue.size());
                Thread.sleep((long) (Math.random() * 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
