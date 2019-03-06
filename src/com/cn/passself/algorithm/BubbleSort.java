package com.cn.passself.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序以及优化方案
 */
public class BubbleSort {

    public static int[] bubble(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                sum++;
            }
        }
        System.out.println("交换" + sum + "次数");
        return arr;
    }

    /**
     * 优化一 在交换的地方加一个标记，如果这一趟循环没有交换数据，证明已经是有序
     * 适用于整体无序的，对于前大半部分无序，后面小半部分有序的数据排序效率一般，于是优化2
     * @param arr
     * @return
     */
    public static int[] bubble2(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                    sum++;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println("2 循环" + sum + "次数");
        return arr;
    }

    /**
     * 优化二
     * @return
     */
    public static int[] bubbleOpt2(int array[]){
        if (array == null || array.length <= 1){
            return array;
        }
        int sum = 0;
        int i,j,temp,length = array.length;
        int flag = 1;//flag =1 标示循环还没有结束，0标示循环结束了。

        for (i = 0; i <length-1 && flag ==1; i++) {
            //如果以后的循环不改变flag的值，证明没有发生数据交换
            //也就是说这个数组排好序了
            flag = 0;
            for (j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    flag = 1;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sum++;
                }
            }
        }
        System.out.println("bubbleOpt2 循环" + sum + " 次数");
        return array;
    }

    /**
     * 优化
     * @param array
     * @return
     */
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

    /**
     * 双向遍历
     * @param array
     * @return
     */
    public static int[] bothArray(int array[]){
        if (array == null || array.length <= 1){
            return array;
        }
        int length = array.length;
        int i = 0,j= 0;
        int flag = 0;
        int n = 0;//同时找最大值和最小值两个下标遍历
        int pos = 0;
        int k = length -1;
        int sum = 0;
        for (i = 0; i < length - 1; i++) {//确定排序趟数

            flag = 0;
            pos = 0;
            //正向寻找最大值
            for (j = n; j < k; j++) {
                if (array[j]>array[j+1]){

                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    flag = 1;//加入标记
                    pos = j;//交换元素，记录最后一次交换的位置
                    sum++;
                }
            }

            if (flag == 0){
                break;
            }

            k = pos;//下一次比较到记录位置即可
            //反向寻找最小值
            for (j=k;j>n;j--){
                if (array[j]<array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    flag = 1;
                    sum++;
                }
            }
            n++;
            if (flag == 0)//如果没有交换过元素，则已经有序,直接结束
            {
                break;
            }
        }

        System.out.println("bubble03 循环" + sum + " 次数");
        return array;
    }

    public static void main(String[] args) {

        int score[] = {17, 16, 35, 17, 19, 9, 29, 10,12,2,1};
        //55次
        /*int firstBubble[] = bubble(score);
        System.out.println("first " + Arrays.toString(firstBubble));*/

        //40次
//        int[] secondBubble = bubble2(score);
//        System.out.println("secondBubble "+Arrays.toString(secondBubble));

        //40次
//        int[] lastBubble = bubbleOpt2(score);
//        System.out.println("lastBubble "+Arrays.toString(lastBubble));

//        int[] bubble_03 = bubble03(score);
//        System.out.println("bubble_03 "+Arrays.toString(bubble_03));
        int[]  bothArray = bothArray(score);
        System.out.println("bothArray is:"+Arrays.toString(bothArray));
    }
}
