package com.cn.passself.leetcode;

import java.util.PriorityQueue;

/**
 * Created by shx on 2019/1/24.
 */
public class Let703 {
    PriorityQueue<Integer> priorityQueue = null;
    int k =0;

    public Let703(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);

        for (int num: nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() <k){
            priorityQueue.add(val);
        }
        else if (priorityQueue.peek() <val){
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
