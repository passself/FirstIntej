package com.cn.passself.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shihuaxian on 2017/4/26.
 */
public class LockTest {

    public static void main(String[] args){
        final OutPuter outPuter = new OutPuter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    outPuter.outputLock("zhangxiaoxiang");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    outPuter.outputLock("lihuoming");
                }
            }
        }).start();
    }


    static class OutPuter{
        Lock lock = new ReentrantLock();
        public void output(String s){
            int length = s.length();
            synchronized (OutPuter.class){
                for (int i = 0; i < length; i++) {
                    System.out.print(s.charAt(i));
                }
            }
            System.out.println();
        }

        public void outputLock(String s){
            int length = s.length();
            //synchronized (OutPuter.class){
            lock.lock();
            try {
                for (int i = 0; i < length; i++) {
                    System.out.print(s.charAt(i));
                }
            }finally {
                lock.unlock();
            }
            //}
            System.out.println();
        }
    }
}
