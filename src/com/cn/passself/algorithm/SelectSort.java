package com.cn.passself.algorithm;

/**
 * 选择排序
 * https://www.cnblogs.com/shen-hua/p/5424059.html
 *
 * 原理: 一种简单直观的排序算法。它的工作原理是每一次从待排序的数组元素中找到一个最小值（最大），
 * 放到队列的起始位置
 */
public class SelectSort {

    public static int[] selectSort(int[] arrays){

        if (arrays!= null && arrays.length>1){
            //int temp = arrays[0];
            //第一层遍历选择n次
            for (int i = 0; i < arrays.length-1; i++) {

                //第一个做为基准
                int k = i;

                for (int j = i+1; j < arrays.length; j++) {

                    if (arrays[j] < arrays[k]){
                        k = j;//记录最小值所在位置
                    }
                }
                //在内层循环结束后，和最小值放到基准位置

                if (k != i){//交换值
                    int temp = arrays[i];
                    arrays[i] = arrays[k];
                    arrays[k] = temp;
                }
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        selectSort(arr);
        System.out.println();
        System.out.println("交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
