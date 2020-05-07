package com.cn.passself.leetcode;

public class Leet747 {

    public static int dominatIndex(int[] nums){
        if(nums == null || nums.length <2){
            return 0;
        }
        int max = 0; int secondMax = 0; int index = -1;
        for(int i = 0;i<nums.length; i++){
            if (nums[i] > max){
                secondMax = max;
                max = nums[i];
                index = i;
            }else if (secondMax < nums[i]){
                secondMax = nums[i];
            }
        }
        return max >= secondMax * 2 ? index:-1;
    }
}
