package com.cn.passself.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 快排，递归和非递归
 * 为什么必须先从右侧循环
 * 参考 https://blog.csdn.net/mwb1219/article/details/51263379
 * https://blog.csdn.net/Alyson_jm/article/details/80304210
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

    public static void quickSortNew(int array[],int low,int high){
        if (low > high){
            return;
        }
        int l,r,pivot;//左右哨兵和枢轴
        l = low;
        r = high;
        pivot = array[low];
        //枢轴值,每次指定为该组的第一个数
        while (l < r){
            //先看右边，依次向左递减
            //先从右边找到一个小于基准位的数
            //当右边的哨兵位置所在的数>基准位的数时，继续从右边找(同时j索引-1)
            while (array[r] >= pivot && l<r){
                r--;
            }

            //再看左边，依次往右递增
            while (array[l] <= pivot && l < r){
                l++;
            }

            if (l < r){
                //临时变量用于交换数据,左右哨兵，交换数据(相互持有对方的数据)
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }//跳出while
        //说明l和r是左右在同一个位置

        //最后将基准为l=r相等的位置的数据进行交换
        array[low] = array[l];
        array[l] = pivot;
        //到这里 i=j
        //这时  左半数组<(i或j所在索引的数)<右半数组
        //也就是说(i或j所在索引的数)已经确定排序位置， 所以就不用再排序了，
        // 只要用相同的方法 分别处理  左右数组就可以了
        quickSortNew(array, low, l-1);
        quickSortNew(array, low+1, high);
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
        quickSortNew(arr,0,arr.length-1);
        //noRecQuickSort(arr,0,arr.length-1);
        System.out.println("final "+Arrays.toString(arr));
    }
}
