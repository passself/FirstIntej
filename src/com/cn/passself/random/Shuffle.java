package com.cn.passself.random;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by shx on 2017/8/2.
 * 洗牌的方法
 * 思路:从后往前，逐个给每个数组位置重新赋值,值是从剩下的元素中挑选的
 */
public class Shuffle {

    public static void main(String[] args){

        int[] arr = new int[13];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println("before:"+Arrays.toString(arr));
        shuffle(arr);
        System.out.println("after:"+Arrays.toString(arr));
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void shuffle(int[] arr){
        Random rnd = new Random();
        for (int i = arr.length; i > 1 ; i--) {
            swap(arr,i-1, rnd.nextInt(i));
        }
    }
}
