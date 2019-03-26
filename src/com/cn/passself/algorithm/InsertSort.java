package com.cn.passself.algorithm;

/**
 * 插入排序
 * 原理:直接插入排序是一种简单的排序，其基本思想是:把待排序的记录按其码值的大小逐个插入到一个已经排好序的有序序列中
 * 直到所有的记录插入完为止，得到一个新得有序序列
 * https://www.cnblogs.com/bjh1117/p/8335628.html
 */
public class InsertSort {


    public static int[] straightSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//用作比较的数据
            int indexLeft = i-1;
            while (indexLeft >=0 && arr[indexLeft]>temp){
                arr[indexLeft+1]= arr[indexLeft];
                indexLeft--;
            }
            arr[indexLeft+1]= temp;//把temp 放到空位上
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
