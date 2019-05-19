package com.cn.passself.lintcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://www.lintcode.com/problem/largest-number/description
 * 重点是比较排序 ASCII 码自动来匹配比较
 */
public class Lintcode184 {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }

        while (sb.length()>1 && sb.charAt(0)=='0'){
            sb.delete(0,1);
        }
        return sb.toString();
    }
}
