package com.cn.passself.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        final Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            business.main(i);
        }
    }


    static class Business{
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        private boolean bShouldSub = true;

        public void sub(int i){
            lock.lock();
            try {
                while (!bShouldSub) {
                    try {
                        //this.wait();
                        condition.await();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                for (int j = 1; j <= 10; j++) {
                    System.out.println("sub thread sequence of " + j + " loop of " + i);
                }
                bShouldSub = false;
                //this.notify();
                condition.signal();
            }finally {
                lock.unlock();
            }
        }

        public void main(int i){
            lock.lock();
            try {
                while (bShouldSub) {
                    try {
                        //this.wait();
                        condition.await();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                for (int j = 1; j <= 100; j++) {
                    System.out.println("main thread sequence of " + j + " loop of " + i);
                }
                bShouldSub = true;
                //this.notify();
                condition.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}
