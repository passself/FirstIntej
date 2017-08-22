package com.cn.passself.test;

import java.util.Date;
import java.util.Properties;

/**
 * Created by shx on 17/2/16.
 */
public class Property {

    public static void main(String[] args){
        System.out.println(new Date());

        Properties p = System.getProperties();
        p.list(System.out);
        System.out.println("---Memory Usage:");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total Memory = " + rt.totalMemory() + " Free Memory = " + rt.freeMemory());
    }
}
