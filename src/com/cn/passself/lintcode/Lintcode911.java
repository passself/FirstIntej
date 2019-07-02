package com.cn.passself.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/maximum-size-subarray-sum-equals-k/description
 * 给一个数组nums和目标值k，找到数组中最长的子数组，使其中的元素和为k。如果没有，则返回0。
 */
public class Lintcode911 {
    public int maxSubArrayLen(int[] nums,int k){
        if (nums == null || nums.length ==0){
            return 0;
        }

        int length = nums.length;
        Map<Integer,Integer> maps = new HashMap<>();
        maps.put(0,0);
        int reuslt = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum+= nums[i];
            int target = sum - k;
            if (maps.containsKey(target)){
                reuslt= Math.max(reuslt,i-maps.get(target));
            }
            if (!maps.containsKey(sum)){
                maps.put(sum,i);
            }
        }
        return reuslt;
    }
}
