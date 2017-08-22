package com.cn.passself.parent;

/**
 * Created by shx on 2017/7/6.
 */
public class Child extends Base{
    public static String s = "child_base";
    public String m = "child";

    public static void staticTest(){
        System.out.println("child static: "+s);
    }
}
