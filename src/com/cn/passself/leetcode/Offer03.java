package com.cn.passself.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 数组中重复的数字
 */
public class Offer03 {

    /**
     * 如果没有重复的数字，那么正常排序后，数字i应该在下标为i的位置，所以思路是重头扫描数组，
     * 遇到下标为i的数字如果不是i的话，(假如为m)，那么我们就拿与下标m的数字交换。在交换的过程中，
     * 如果有重复的数字发生，那么终止返回true
     * 参考
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution
     * /yuan-di-zhi-huan-shi-jian-kong-jian-100-by-derrick/
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int nums[]) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            /**
             * 如果当前的数nums[i]没有在下标为i的位置上，就把它交换到小标为i上
             * 交换过来的数据还得做相同的操作，因此用while
             */
            System.out.println(Arrays.toString(nums));
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    //如果下标为nums[i]的数值nums[nums[i]] 他们二者相等
                    //正好找到了重复元素，直接返回
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 官方使用了set
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberG(int nums[]) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
