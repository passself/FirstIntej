package com.cn.passself.symbol;

/**
 * Created by shx on 17/2/21.
 */
public class URShift {

    public static void main(String[] args){
        int i = -1;
        System.out.println(i);
        i >>>= 10;
        System.out.println(i);
        long l = -1;
        l >>>= 10;
        System.out.println(l);
        short s = -1;
        s >>>= 10;
        System.out.println(s);
        byte b = -1;
        b >>>= 10;
        System.out.println(b);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("enter runnable");
            }
        }){
            @Override
            public void run() {//先找自己的run方法，自己没有的话再去找父类run方法，但是子类必须调用super.run();
                super.run();
                //System.out.println("self run");
            }
        }.start();

        int x=0 ,y=1;
        int z = (x ^ y);
        System.out.println("--"+z);
        //定时器

    }
}
