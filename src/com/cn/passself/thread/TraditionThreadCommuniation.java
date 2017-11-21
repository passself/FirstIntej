package com.cn.passself.thread;

public class TraditionThreadCommuniation {

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
        private boolean bShouldSub = true;

        public synchronized void sub(int i){
            while (!bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            for (int j = 0; j < 10; j++) {
                System.out.println("sub thread sequence of " + j + " loop of " + i);
            }
            bShouldSub = false;
            this.notify();
        }

        public synchronized void main(int i){
            while (bShouldSub){
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            for (int j = 0; j < 100; j++) {
                System.out.println("main thread sequence of " + j + " loop of " + i);
            }
            bShouldSub = true;
            this.notify();
        }
    }
}
