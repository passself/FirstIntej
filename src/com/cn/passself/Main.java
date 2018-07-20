package com.cn.passself;

import com.cn.passself.aes.AESOperator;

import java.util.concurrent.*;

/**
 * 
 * @author shihx1
 *
 */
public class Main {
    public static void main(String[] args){
        System.out.println("-----");

        String beforeCipherText = "1232434";
        System.out.println("加密前："+beforeCipherText);
        String cipherText = null;
        try {
            cipherText = AESOperator.getInstance().encrypt(beforeCipherText);
            System.out.println("加密后："+cipherText);
            System.out.println("解密后:"+AESOperator.getInstance().decrypt(cipherText));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Executor executor = Executors.newFixedThreadPool(3);
        long time = 0;
        try {
            time = time(executor, 3, new Runnable() {
                @Override
                public void run() {
                    System.out.println("new .Runnable()");
                }
            });
            System.out.println("time is:"+time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final ConcurrentMap<String,String> map = new ConcurrentHashMap<>();

    public static String intern(String s){
        String previousValue = map.putIfAbsent(s,s);
        return previousValue == null ? s : previousValue;
    }

    /**
     * hashmap优化了get方法，则用get方法来优化代码
     * @param s
     * @return
     */
    public static String internNew(String s){
        String result = map.get(s);
        if (result == null){
            result = map.putIfAbsent(s,s);
            if (result == null)
                result = s;
        }
        return result;
    }

    public static long time(Executor executor,int concurrency,final Runnable action) throws InterruptedException{
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ready.countDown();
                    System.out.println("ready.countDown()");
                    try {
                        System.out.println("start.await()");
                        start.await();
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }finally {
                        System.out.println("done.countDown()");
                        done.countDown();
                    }
                }
            });
        }
        ready.await();
        long startNanos = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - startNanos;
    }
}