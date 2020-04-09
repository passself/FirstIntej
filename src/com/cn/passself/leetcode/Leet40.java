package com.cn.passself.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 */
public class Leet40 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        int min = 0;
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /**
     * 大顶堆和小顶堆来实现
     *
     * @param arr
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[]{};
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    /**
     * // 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
     * // 1. 若目前堆的大小小于K，将当前数字放入堆中。
     * // 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
     * //    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     * java 默认小顶堆
     *
     * @param arr
     */
    public int[] getLeastNumbersPQ(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //默认是小顶堆，实现大顶堆需要重写一下比较器
        Queue<Integer> qp = new PriorityQueue<>((v1,v2) -> v2-v1);
        for (int num:arr){
            if(qp.size() <k){
                qp.offer(num);
            }else if(num <qp.peek()){
                qp.poll();
                qp.offer(num);
            }
        }

        //返回堆中的元素
        int[] res = new int[qp.size()];
        int inx = 0;
        for(int num:qp){
            res[inx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 2, 1, 4};
        int k = 2;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }
}
