package com.cn.passself.leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/comments/
 */
public class Leet16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closetNum - target)) {
                    closetNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    return target;
                }
            }
        }
        return closetNum;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums,-1));
    }
}
