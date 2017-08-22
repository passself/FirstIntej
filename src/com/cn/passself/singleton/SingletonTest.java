package com.cn.passself.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shx on 17/2/15.
 */
public class SingletonTest {

    boolean lock;

    public boolean isLock(){
        return this.lock;
    }

    public void setLock(boolean lock){
        this.lock = lock;
    }

    public static void main(String[] args) throws InterruptedException{
        //System.out.println("hello singleton");
        final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());
        final SingletonTest test = new SingletonTest();
        test.setLock(true);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        boolean flag = !test.isLock();
                        System.out.println(Thread.currentThread().getName() + " " + flag);
                        if (flag) {
                            CommonSingleton singleton = CommonSingleton.getInstance();
                            instanceSet.add(singleton.toString());
                            break;
                        }
                    }
                }
            });
        }
        Thread.sleep(5000);
        test.setLock(false);
        Thread.sleep(5000);
        System.out.println("------并发情况下我们取到的实例------");
        for (String instance:instanceSet){
            System.out.println(instance);
        }
        executorService.shutdown();
        System.out.println("------end------");
    }
}
