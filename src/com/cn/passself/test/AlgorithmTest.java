package com.cn.passself.test;

import java.util.Arrays;

/**
 * Created by shx on 2019/3/26.
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        int score[] = {17, 16, 35, 17, 19, 9, 29, 10, 12, 2, 1};
        int[] newResult = bubbleSortNew(score);
        //System.out.println("bubbleSort is:" + Arrays.toString(score));
        System.out.println("bubbleOpt2 is:" + Arrays.toString(newResult));
    }

    public static int[] bubbleSort(int array[]) {
        if (array == null) {
            return array;
        }
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length -i- 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    sum ++;
                }
            }
        }
        System.out.println("交换了"+sum+"次");
        return array;
    }

    public static int[] bubbleSort2(int array[]) {
        if (array == null) {
            return array;
        }
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length -i- 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    sum ++;
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
        System.out.println("交换了"+sum+"次");
        return array;
    }

    public static int[] bubble03(int array[]){
        if (array == null || array.length <= 1){
            return array;
        }
        int sum = 0;
        int i = 0, j = 0;
        int temp = 0;
        int flag = 0;
        int pos = 0;//用来记录最后一次交换的位置
        int length = array.length;
        for (i = 0; i < length; i++) {

            flag = 0;
            pos = 0;
            j = 0;
            for (j = 0; j < length - i - 1; j++) {

                if (array[j] > array[j+1]){
                    //交换
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = 1;//加入标记
                    pos = j;//交换元素，记录最后一次交换的位置
                    sum++;
                }
            }
            if (flag == 0){//如果没有交换过元素，则已经有序
                break;
            }
            length = pos;//下一次比较到记录位置即可
        }
        System.out.println("bubble03 循环" + sum + " 次数");
        return array;
    }

    // 冒泡排序，a 表示数组，n 表示数组大小
    public  static int[] bubbleSortNew(int[] a) {
        int n = a.length;
        if (n <= 1) return a;

        int sum = 0;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                    sum ++;
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
        System.out.println("交换了"+sum+"次");
        return a;
    }
}
