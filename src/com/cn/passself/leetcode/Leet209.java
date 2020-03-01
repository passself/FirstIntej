package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet209 {
    public static int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int right = i;
            int sum = 0;
            while(right <length){
                sum +=nums[right];
                right++;
                //当前
                if (sum>=s){
                    min = Math.min(min,right-i);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }


    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
        System.out.println(minSubArrayLen2(7,nums));
    }

    /**
     * s = 7, nums = [2,3,1,2,4,3]
     *
     * 2 3 1 2 4 3
     * ^
     * l
     * r
     * 上边的窗口内所有数字的和 2 小于 7, r 右移
     *
     * 2 3 1 2 4 3
     * ^ ^
     * l r
     * 上边的窗口内所有数字的和 2 + 3 小于 7, r 右移
     *
     * 2 3 1 2 4 3
     * ^   ^
     * l   r
     * 上边的窗口内所有数字的和 2 + 3 + 1 小于 7, r 右移
     *
     * 2 3 1 2 4 3
     * ^     ^
     * l     r
     * 上边的窗口内所有数字的和 2 + 3 + 1 + 2 大于等于了 7, 记录此时的长度 min = 4, l 右移
     *
     * 2 3 1 2 4 3
     *   ^   ^
     *   l   r
     * 上边的窗口内所有数字的和 3 + 1 + 2  小于 7, r 右移
     *
     * 2 3 1 2 4 3
     *   ^     ^
     *   l     r
     * 上边的窗口内所有数字的和 3 + 1 + 2 + 4 大于等于了 7, 更新此时的长度 min = 4, l 右移
     *
     * 2 3 1 2 4 3
     *     ^   ^
     *     l   r
     * 上边的窗口内所有数字的和 1 + 2 + 4 大于等于了 7, 更新此时的长度 min = 3, l 右移
     *
     * 2 3 1 2 4 3
     *       ^ ^
     *       l r
     * 上边的窗口内所有数字的和 2 + 4 小于 7, r 右移
     *
     * 2 3 1 2 4 3
     *       ^   ^
     *       l   r
     * 上边的窗口内所有数字的和 2 + 4 + 3 大于等于了 7, 更新此时的长度 min = 3, l 右移
     *
     * 2 3 1 2 4 3
     *         ^ ^
     *         l r
     * 上边的窗口内所有数字的和 4 + 3 大于等于了 7, 更新此时的长度 min = 2, l 右移
     *
     * 2 3 1 2 4 3
     *           ^
     *           r
     *           l
     * 上边的窗口内所有数字的和 3 小于 7, r 右移，结束
     *
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-43/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int minSubArrayLen2(int s ,int[] nums){
        int l = 0,r = 0;
        int length = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(r <length){
            sum+=nums[r];
            //r++;
            while(sum >= s){
                min = Math.min(min,r -l+1);
                sum -=nums[l];
                l++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }
}
