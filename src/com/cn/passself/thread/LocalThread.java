package com.cn.passself.thread;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by shx on 17/3/8.
 */
public class LocalThread {

    private static int data = 0;
    private static HashMap<Thread,Integer> hashMap = new HashMap<>();
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
    public static void main(String[] args){
        for (int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data " + data);
                    hashMap.put(Thread.currentThread(),data);
                    x.set(data);
                    MyThreadScopeData.getInstance().setName("张三"+data);
                    MyThreadScopeData.getInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get(){
            //int data =
            //System.out.println("A from "+Thread.currentThread().getName() + " get data " + data);
            //System.out.println("A from "+Thread.currentThread().getName() +" get data"+hashMap.get(Thread.currentThread()));
            //System.out.println("A from "+Thread.currentThread().getName() +" x get data "+x.get());
            MyThreadScopeData data = MyThreadScopeData.getInstance();
            System.out.println("A from "+Thread.currentThread().getName()  + " getName is:"+data.getName() + " getAge is:"+data.getAge());
        }
    }

    static class B {
        public void get(){
            //int data =
            //System.out.println("B from "+Thread.currentThread().getName() + " get data " + data);
            //System.out.println("B from "+Thread.currentThread().getName() +" get data"+hashMap.get(Thread.currentThread()));
            //System.out.println("B from "+Thread.currentThread().getName() +" x get data "+x.get());

            MyThreadScopeData data = MyThreadScopeData.getInstance();
            System.out.println("b from "+Thread.currentThread().getName()  + " getName is:"+data.getName() + " getAge is:"+data.getAge());
        }
    }
}

class MyThreadScopeData{
    private MyThreadScopeData(){}
    //private static MyThreadScopeData instance;
    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();

    public static MyThreadScopeData getInstance(){
        MyThreadScopeData instance = map.get();
        if (instance == null){
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
