package com.cn.passself.thread.consumer;

/**
 * Created by shihuaxian on 2018/1/3.
 */
public class Producer extends Thread {

    SelfBlockQueue<String> myBlockQueue;
    //MyBlockQueue<String> myQueue;

    public Producer(SelfBlockQueue<String> queue){
        this.myBlockQueue = queue;
    }

    /*public Producer(MyBlockQueue<String> queue){
        this.myQueue = queue;
    }*/

    @Override
    public void run() {
        int num = 0;
        while (true){
            String task = String.valueOf(num);
            try {
                myBlockQueue.put(task);
                System.out.println("produce task "+task+"--queue.size() is:"+myBlockQueue.size());
                num ++;
                Thread.sleep((long) (Math.random()*100));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
