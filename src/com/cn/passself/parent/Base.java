package com.cn.passself.parent;

/**
 * Created by shx on 2017/7/6.
 */
public class Base {
    public static String s = "static_base";
    public String m = "base";

    public static void staticTest(){
        System.out.println("base static: "+s);
    }
}
