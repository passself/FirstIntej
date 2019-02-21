package com.cn.passself.thread;

/**
 * demo 来自 https://www.jianshu.com/p/411c40b09a81
 * synchronized 是时间换空间 ThreadLocal 是空间换时间
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocal<Boolean> mBooleanThreadLocal = ThreadLocal.withInitial(() -> false);

        mBooleanThreadLocal.set(true);

        System.out.println("[Thread#main]mBooleanThreadLocal=" +mBooleanThreadLocal.hashCode()+"  " +
                 mBooleanThreadLocal.get());

        new Thread("Thread#1"){
            @Override
            public void run() {
                mBooleanThreadLocal.set(false);
                System.out.println("[Thread#1]mBooleanThreadLocal="+mBooleanThreadLocal.hashCode()+"  "
                        +mBooleanThreadLocal.get());
            }
        }.start();

        new Thread("Thread#2") {
            @Override
            public void run() {
                System.out.println( "[Thread#2]mBooleanThreadLocal="+mBooleanThreadLocal.hashCode() + "  "
                        +mBooleanThreadLocal.get());
            }
        }.start();


        //再测试一个demo
        ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int num = local.get();
                    for (int j = 0; j < 5; j++) {
                        num++;
                    }
                    local.set(num);
                    System.out.println(Thread.currentThread().getName() + " : "+ local.get());
                }
            },"Thread-"+i);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
