package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子序和
 */
public class Leet53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int maxSubArrayDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 上一个方法的延伸
     *
     * @param nums
     * @return
     */
    public int maxSubArrayDp1(int[] nums) {
        int[] dp = new int[nums.length];
        //起名叫pre 表示的意思是"上一个"状态的值
        int pre = nums[0];
        int res  = pre;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + dp[i - 1], nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }


}
