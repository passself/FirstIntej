package com.cn.passself.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shx on 2019/1/27.
 */
public class Leet368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent  = new int[n];
        int max = 0, max_idx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                max_idx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        do {
            res.add(nums[max_idx]);
            max_idx = parent[max_idx];
        } while (max_idx != -1);
        return res;
    }

    public List<Integer> largestDivisibleSubset1(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if(nums.length < 1) return new ArrayList();
        int max = 0;
        int p = 0;
        for(int k = 0; k < nums.length; k++){
            list.add(k, new ArrayList());
        }

        if(nums.length >= 1){
            Arrays.sort(nums);
            int[] leng = new int[nums.length];
            int j = 0;
            for(int i = 0; i < nums.length; i++){
                for(j = i - 1; j >= 0; j--){
                    if(nums[i] % nums[j] == 0 && nums[i] > nums[j]){
                        if(leng[i] < leng[j] + 1){
                            leng[i] = leng[j] + 1;
                            list.set(i,new ArrayList(list.get(j)));
                            list.get(i).add(nums[i]);
                            if(max < leng[i]) {
                                max  = leng[i];
                                p = i;
                            }
                        }
                    }
                }
                if(j < 0 && leng[i] == 0) {
                    list.get(i).add(nums[i]);
                    leng[i] = 1;
                }

            }
        }
        return list.get(p);
    }
}
