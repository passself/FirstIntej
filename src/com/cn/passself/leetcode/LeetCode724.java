package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/find-pivot-index/
 */
public class LeetCode724 {

    public int pivotIndex(int[] nums){
        int sum = 0,sumLeft = 0,sumRight=0;

        for (int n:nums) {
             sum +=n;
        }

        for (int i=0;i<nums.length;i++){
            if(i==0){
               sumLeft = 0;
            }else{
                sumLeft = sumLeft+nums[i-1];
            }

            sumRight = sum -sumLeft - nums[i];
            if (sumLeft ==sumRight){
                return i;
            }
        }
        return -1;
    }
}
