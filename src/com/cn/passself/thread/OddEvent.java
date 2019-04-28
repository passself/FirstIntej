package com.cn.passself.thread;

/**
 * 奇偶数交替打印
 *https://www.cnblogs.com/study-everyday/p/6292738.html
 */
public class OddEvent {

    public boolean isFlag = true;

    public static void main(String[] args) {

    }

    public class OddRunnable implements Runnable{

        OddEvent event;
        public OddRunnable(OddEvent event){
            this.event = event;
        }

        @Override
        public void run() {
            synchronized (event){
                int i = 2;
                while (i<100) {
                    if (event.isFlag) {
                        System.out.println("偶数：" + i);
                        i = i + 2;
                        event.isFlag = false;
                        event.notify();
                    }else {
                        try {
                            event.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
