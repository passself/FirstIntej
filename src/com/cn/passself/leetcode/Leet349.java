package com.cn.passself.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Leet349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> recordSet = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for(int num:nums1){
            recordSet.add(num);
        }
        for (int num : nums2) {
            if (recordSet.contains(num)){
                resultSet.add(num);
            }
        }
        int resultArray[] = new int[resultSet.size()];
        int index = 0;
        for(int value:resultSet){
            resultArray[index++] = value;
        }
        return resultArray;
    }

    public int[] intersection2Point(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {
            res[index++] = num;
        }

        return res;
    }
}
