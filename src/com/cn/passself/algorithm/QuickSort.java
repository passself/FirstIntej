package com.cn.passself.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 快排，递归和非递归
 * 为什么必须先从右侧循环
 * 参考 https://blog.csdn.net/mwb1219/article/details/51263379
 */
public class QuickSort {

    public static void quickSort(int array[],int start,int end){
        if (start < end){
            int pvoit = array[start];
            int left = start;
            int right = end;

            while (left < right){
                System.out.println(" left=" + left + ", right=" + right + ", pvoit=" + pvoit);
                while (left < right && array[right] >= pvoit){
                    right --;
                }

                if (left < right){
                    array[left++] = array[right];
                }

                while (left<right && array[left] <= pvoit){
                    left ++;
                }
                if (left <right){
                    array[right --] = array[left];
                }
                System.out.println(Arrays.toString(array));
            }
            System.out.println("==============================================");
            array[left] = pvoit;
            quickSort(array,start,left-1);
            quickSort(array,left+1,end);
        }
    }

    /**
     * 非递归
     * @param array
     * @param start
     * @param end
     */
    public static void noRecQuickSort(int[] array,int start,int end){
        LinkedList<Integer> stack = new LinkedList<Integer>();//用栈来模拟
        if (start < end){
            stack.push(end);
            stack.push(start);

            while (!stack.isEmpty()){
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(array,l,r);

                if (l < index -1){
                    stack.push(index -1);
                    stack.push(l);
                }

                if (r > index +1){
                    stack.push(r);
                    stack.push(index+1);
                }
            }
        }
    }

    public static int partition(int[] a, int start, int end){
        int pivot = a[start];
        while (start<end){
            while (start < end && a[end] >= pivot){
                end --;
            }
            a[start] = a[end];
            while (start < end && a[start] <= pivot){
                start ++;
            }
            a[end] = a[start];
        }
        a[start] = pivot;

        return start;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1,6,3,4,11,2,3,5,6};
        //quickSort(arr,0,arr.length-1);
        noRecQuickSort(arr,0,arr.length-1);
        System.out.println("final "+Arrays.toString(arr));
    }
}
