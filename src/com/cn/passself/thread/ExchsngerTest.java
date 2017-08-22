package com.cn.passself.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shx on 2017/5/11.
 */
public class ExchsngerTest {
    public static void main(String[] args){
        Exchanger<String> exchanger = new Exchanger<String>();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "接收方";
                System.out.println("线程"+Thread.currentThread().getName()+"正把数据 "+data1+" 换出去");
                try {
                    Thread.sleep((long)(Math.random()*10000));
                    String data2 = exchanger.exchange(data1);
                    System.out.println("线程"+Thread.currentThread().getName()+"换回的数据是:"+data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "发送方";
                System.out.println("线程"+Thread.currentThread().getName()+"正把数据 "+data1+" 换出去");
                try {
                    Thread.sleep((long)(Math.random()*10000));
                    String data2 = exchanger.exchange(data1);
                    System.out.println("线程"+Thread.currentThread().getName()+"换回的数据是:"+data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
