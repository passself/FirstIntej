package com.cn.passself.leetcode;

/**
 *
 */
public class Leet53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int ans = nums[0];
        int sum = 0;
        for(int num:nums){
            if (num > 0){
                sum +=num;
            }else{
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    public int maxSubArrayDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i =0;i< nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-1],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
