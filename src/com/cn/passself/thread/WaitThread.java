package com.cn.passself.thread;

/**
 * Created by shihuaxian on 2018/1/3.
 */
public class WaitThread extends Thread{

    private volatile boolean isFire = false;

    @Override
    public void run() {
        try {
            System.out.println("--"+this);
            synchronized (this) {//加锁
                while (!isFire) {
                    wait();
                }
            }
            System.out.println("fired");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void fire(){
        this.isFire = true;
        notify();
    }

    public static void main(String[] args) throws InterruptedException{
        WaitThread thread = new WaitThread();
        thread.start();
        System.out.println("thread is:"+thread);
        Thread.sleep(1000);
        System.out.println("fire");
        thread.fire();
    }
}
