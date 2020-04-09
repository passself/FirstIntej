package com.cn.passself.leetcode;
import	java.util.PriorityQueue;

public class Leet215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> (k);
        for(int num : nums){
            if(pq.size() < k || num>pq.peek()){
                pq.offer(num);
            }
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
