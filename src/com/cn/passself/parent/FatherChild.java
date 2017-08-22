package com.cn.passself.parent;

/**
 * Created by shx on 2017/7/6.
 */
public class FatherChild {

    public static void main(String[] str){
        Child c = new Child();
        Base b = c;

        System.out.println(b.s);
        System.out.println(b.m);
        b.staticTest();

        System.out.println(c.s);
        System.out.println(c.m);
        c.staticTest();
    }
}
