package com.cn.passself.thread;

/**
 * Created by shihuaxian on 2018/1/29.
 */
public class InterruptSynchronizedDemo {
    private static Object lock = new Object();

    private static class A extends Thread{
        @Override
        public void run() {
            synchronized (lock){
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("while");
                }
            }
            System.out.println("exit");
        }
    }

    public static void test() throws InterruptedException{
        synchronized (lock){
            A a = new A();
            a.start();
            Thread.sleep(1000);

            a.interrupt();
            //a.join();
        }
    }

    private static int counter=0;
    public static void increase(){
        counter++ ;
        System.out.println("increase is:"+counter);
    }

    public static void decrease(){
        counter-- ;
        System.out.println("decrease is:"+counter);
    }


    public static void main(String[] args) throws InterruptedException{
        test();
    }
}
