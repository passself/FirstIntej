package com.cn.passself.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class Leet15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for (List l : result) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    public static List<List<Integer>> sumTotal(int nums[]) {
        if (nums == null || nums.length < 3) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        int l = 0, r = 0;

        Arrays.sort(nums);

        for (int i = 0; i < length - 1; i++) {

            l = i + 1;
            r = length - 1;

            if (i == 0 || nums[i] == nums[i - 1]) {
                continue;
            }
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;

                    while (l < r && (nums[l] == nums[l - 1])) {
                        l++;
                    }
                    while (l < r && (nums[r] == nums[r - 1])) {
                        r--;
                    }
                } else if (nums[l] + nums[r] < -nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.EMPTY_LIST;
        }

        int left = 0, right = 0;
        int length = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < length - 1; i++) {

        }

        return result;
    }
}
