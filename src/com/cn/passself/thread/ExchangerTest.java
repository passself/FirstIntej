package com.cn.passself.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shihuaxian on 2017/5/14.
 */
public class ExchangerTest {
    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        final Exchanger<String> exchanger = new Exchanger<String>();

        service.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "data1";
                try {
                    System.out.println("线程 "+Thread.currentThread().getName() + "正在把数据 "+ data1+" 交换出去");
                    Thread.sleep((long)(Math.random()*1000));
                    String data2 = exchanger.exchange(data1);
                    System.out.println("线程 "+Thread.currentThread().getName() + "换回的数据为 "+ data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        service.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "data2";
                try {
                    System.out.println("线程 "+Thread.currentThread().getName() + "正在把数据 "+ data1+" 交换出去");
                    Thread.sleep((long)(Math.random()*1000));
                    String data2 = exchanger.exchange(data1);
                    System.out.println("线程 "+Thread.currentThread().getName() + "换回的数据为 "+ data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
