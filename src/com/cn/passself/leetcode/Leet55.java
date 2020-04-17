/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/comments/
 */
public class Leet55 {
    /**
     * 从后向前遍历数组，如果遇到的元素可以到达最后一行，
     * 则截断后边的元素。否则继续往前，若最后剩下的元素大于1，则可以判断为假
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int start = 0;
        int end = 0;
        while (start <= end && end < nums.length - 1) {
            end = Math.max(end, nums[start] + start);
            start++;
        }
        return end >= nums.length - 1;
    }

    /**
     * 官网解法
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums){
        int n = nums.length;
        int rightMax = 0;
        for (int i = 0; i < n; ++i) {
            if (i<= rightMax){
                rightMax = Math.max(rightMax,i+nums[i]);
                if (rightMax >= n -1){
                    return true;
                }
            }
        }
        return false;
    }
}
