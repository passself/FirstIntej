package com.cn.passself.leetcode;

import java.util.ArrayDeque;

/**
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
 */
public class Leet239 {

    /**
     * 方法一：暴力法
     *
     * 直觉
     *
     * 最简单直接的方法是遍历每个滑动窗口，找到每个窗口的最大值。一共有 N - k + 1 个滑动窗口，每个有 k 个元素，于是算法的时间复杂度为
     * O
     * (
     * N
     * k
     * )
     * O(Nk)，表现较差。
     *
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*int n = nums.length;
        if( n * k ==0) return new int[0];
        int[] output = new int[n-k+1];//共这么多窗口
        for(int i = 0; i < n-k+1; i++){
            int max = Integer.MAX_VALUE;
            for (int j = i; j < i+k; j++) {
                max = Math.max(max,nums[j]);
            }
            output[i] = max;
        }
        return output;*/
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }

    /**
     * 双端队列
     * 处理前 k 个元素，初始化双向队列。
     *
     * 遍历整个数组。在每一步 :
     *
     * 清理双向队列 :
     *
     *   - 只保留当前滑动窗口中有的元素的索引。
     *
     *   - 移除比当前元素小的所有元素，它们不可能是最大的。
     * 将当前元素添加到双向队列中。
     * 将 deque[0] 添加到输出中。
     * 返回输出数组。
     *
     */

    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;
    public void clean_deque(int i,int k){
        // remove indexes of elements not from sliding window
        if(!deq.isEmpty() && deq.getFirst() == i-k){
            deq.removeFirst();
        }
        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if(n*k ==0) return new int[0];
        if (k == 1) return nums;

        //init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i,k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        //build output
        for(int i = k; i< n;i++){
            clean_deque(i,k);
            deq.addLast(i);
            output[i-k+1] = nums[deq.getFirst()];
        }
        return output;
    }
}
