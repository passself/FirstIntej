package com.cn.passself.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之后，和三数之和都差不多
 * method1:暴力循环
 * method2:map
 */
public class Leet01 {

    public static void main(String[] args) {
        int nums[] = new int[]{2, 7, 11, 15};
        int nums2[] = new int[]{3, 2, 4};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
        System.out.println(Arrays.toString(twoSumMap(nums2, 6)));
    }

    /**
     * 暴力循环
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * map 来计数
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumMap(int[] nums, int target) {

        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }

        int length = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println("sccess i is:" + i + "--nums[i] is:" + nums[i]);
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            } else {
                System.out.println("i is:" + i + "--nums[i] is:" + nums[i]);
                map.put(nums[i], i);
            }
        }

        return result;
    }

    /**
     * 双指针 排序后的才行不符合本题目
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        Arrays.sort(nums);

        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {

            if (nums[left] + nums[right] == target) {
                System.out.println("ok left is " + left + "--" + nums[left]);
                System.out.println("ok right is " + right + "--" + nums[right]);
                result[0] = left;
                result[1] = right;
                break;
            } else if (nums[left] + nums[right] < target) {
                System.out.println("left is" + left);
                left++;
            } else {
                System.out.println("right is" + right);
                right--;
            }
        }
        //}
        return result;
    }
}
