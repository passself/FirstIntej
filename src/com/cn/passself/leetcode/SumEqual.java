package com.cn.passself.leetcode;

/**
 *
 *  寻找数组的中心索引
 *
 */
public class SumEqual {

    public int pivotIndex(int[] nums){
        int sum = 0,sumLeft=0,sumRight=0;

        for(int item:nums){
            sum += item;
        }
        for(int i =0;i< nums.length; i++){
            if (i == 0){
                sumLeft = 0;
            }else{
                sumLeft += nums[i-1] ;
            }

            sumRight = sum - nums[i] - sumLeft;

            if (sumRight == sumLeft){
                return i;
            }
        }

        return -1;
    }
}
