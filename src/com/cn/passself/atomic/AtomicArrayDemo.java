package com.cn.passself.atomic;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by shihuaxian on 2018/2/7.
 */
public class AtomicArrayDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(arr);

        atomicArray.compareAndSet(1,2,100);
        System.out.println(atomicArray.get(1));
        System.out.println(arr[1]);

        //TreeMap
    }
}
