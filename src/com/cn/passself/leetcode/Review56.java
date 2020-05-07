package com.cn.passself.leetcode;

/**
 * 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class Review56 {

    public int[] singleNumbers(int[] nums) {
        //用于所有数据异或起来
        int k = 0;

        for (int num : nums) {
            k ^= num;
        }

        //获取k中最低位的1
        int mask = 1;

        while ((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
